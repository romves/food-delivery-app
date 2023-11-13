Drop database FoodDeliveryApp
GO
CREATE DATABASE FoodDeliveryApp
GO
USE FoodDeliveryApp
GO

CREATE TABLE Users (
    user_id INT PRIMARY KEY IDENTITY(1,1),
    user_name VARCHAR(50) NOT NULL,
    user_email VARCHAR(255) UNIQUE NOT NULL CHECK (user_email LIKE '%@%.%'),
    user_address VARCHAR(255) NOT NULL,
    user_phone_number VARCHAR(20) UNIQUE NOT NULL,
    user_password VARCHAR(255) NOT NULL CHECK (user_password LIKE '%[a-zA-Z]%' AND user_password LIKE '%[0-9]%'),
    CHECK (LEN(user_name) > 0)
);
CREATE TABLE Restaurant (
    restaurant_id INT PRIMARY KEY IDENTITY(1,1),
    restaurant_name VARCHAR(255) NOT NULL,
    restaurant_email VARCHAR(255) UNIQUE NOT NULL CHECK (restaurant_email LIKE '%@%.%'),
    restaurant_password VARCHAR(255) NOT NULL,
    restaurant_address VARCHAR(255) NOT NULL,
    restaurant_description TEXT,
    restaurant_phone_number VARCHAR(20) UNIQUE NOT NULL,
    restaurant_balance DECIMAL(10, 2) DEFAULT 0.0, -- New column for saldo
    CHECK (LEN(restaurant_name) > 0)
);


CREATE TABLE Products (
    product_id INT PRIMARY KEY IDENTITY(1,1),
    product_name VARCHAR(255) NOT NULL,
    product_price DECIMAL(10, 2) NOT NULL,
    product_type VARCHAR(10) CHECK (product_type IN ('Food', 'Drink')),
    restaurant_id INT,
    CHECK (product_price >= 0),
    FOREIGN KEY (restaurant_id) REFERENCES Restaurant(restaurant_id)
);

CREATE TABLE Payments (
    payment_id INT PRIMARY KEY IDENTITY(1,1),
    payment_status VARCHAR(50) NOT NULL CHECK (payment_status IN ('UNPAID', 'PAID')) DEFAULT 'UNPAID',
    payment_method VARCHAR(50) CHECK (payment_method IN ('CC', 'OVO', 'DANA', 'CASH')),  
    payment_date DATETIME DEFAULT GETDATE(),
);

CREATE TABLE Couriers (
    courier_id INT PRIMARY KEY IDENTITY(1,1),
    delivery_status VARCHAR(50) NOT NULL CHECK (delivery_status IN ('PENDING', 'ON_DELIVERY' ,'DELIVERED')) DEFAULT 'PENDING',
    courier_name VARCHAR(255) NOT NULL,
    courier_phone_number VARCHAR(20) UNIQUE NOT NULL,
    courier_plate_number VARCHAR(20) UNIQUE NOT NULL,
    CHECK (LEN(courier_name) > 0)
);

CREATE TABLE OrderTable (
    order_id INT PRIMARY KEY IDENTITY(1,1),
    order_date DATETIME DEFAULT GETDATE() ,
    order_status VARCHAR(50) CHECK (order_status IN ('PENDING', 'ON_PROCESS', 'FINISHED')) DEFAULT 'PENDING',
    order_total DECIMAL(10,2),
    user_id INT,
    payment_id INT,
    courier_id INT,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (payment_id) REFERENCES Payments(payment_id),
    FOREIGN KEY (courier_id) REFERENCES Couriers(courier_id)
);

CREATE TABLE OrderDetails (
    order_id INT,
    product_id INT,
    quantity INT NOT NULL,
    subtotal DECIMAL(10,2),
    PRIMARY KEY (order_id, product_id),
    CHECK (quantity > 0),
    FOREIGN KEY (order_id) REFERENCES OrderTable(order_id),
    FOREIGN KEY (product_id) REFERENCES Products(product_id)
);
GO


-- Trigger to update subtotal in OrderDetails when a new product is added
CREATE TRIGGER UpdateSubtotalAndTotal
ON OrderDetails
AFTER INSERT
AS
BEGIN
    SET NOCOUNT ON;

    -- Update subtotal in OrderDetails for all affected products
    UPDATE od
    SET od.subtotal = i.quantity * p.product_price
    FROM OrderDetails od
    INNER JOIN inserted i ON od.product_id = i.product_id
    INNER JOIN Products p ON i.product_id = p.product_id;

    -- Update order_total in OrderTable for all affected orders
    UPDATE ot
    SET ot.order_total = ISNULL((SELECT SUM(od.subtotal) FROM OrderDetails od WHERE od.order_id = ot.order_id), 0)
    FROM OrderTable ot
    INNER JOIN inserted i ON ot.order_id = i.order_id;
END;
GO

-- Trigger to update order_status to 'ON_PROCESS' when payment_method is not null
CREATE TRIGGER UpdateOrderStatusOnPayment
ON Payments
AFTER UPDATE
AS
BEGIN
    SET NOCOUNT ON;

    -- Update order_status for all affected orders
    UPDATE ot
    SET ot.order_status = 'ON_PROCESS'
    FROM OrderTable ot
    INNER JOIN inserted i ON ot.payment_id = i.payment_id
    WHERE i.payment_method IS NOT NULL;
END;
GO



-- Trigger to update restaurant_balance when order_status is FINISHED
CREATE TRIGGER UpdateRestaurantBalance
ON OrderTable
AFTER UPDATE
AS
BEGIN
    SET NOCOUNT ON;

    -- Check if order_status is changed to FINISHED
    IF UPDATE(order_status) 
    BEGIN
        DECLARE @OrderID INT;
        DECLARE @OrderTotal DECIMAL(10, 2);
        DECLARE @RestaurantID INT;

        -- Get the order_id, order_total, and restaurant_id
        SELECT @OrderID = i.order_id,
               @OrderTotal = d.order_total,
               @RestaurantID = p.restaurant_id
        FROM inserted i
        INNER JOIN deleted d ON i.order_id = d.order_id
        INNER JOIN OrderDetails od ON i.order_id = od.order_id
        INNER JOIN Products p ON od.product_id = p.product_id
        WHERE i.order_status = 'FINISHED';

        -- Update restaurant_balance
        UPDATE Restaurant
        SET restaurant_balance = restaurant_balance + @OrderTotal
        WHERE restaurant_id = @RestaurantID;
    END;
END;
GO

CREATE TRIGGER UpdateOrderStatus
ON Couriers
AFTER UPDATE
AS
BEGIN
    SET NOCOUNT ON;

    DECLARE @CourierID INT;
    DECLARE @NewDeliveryStatus VARCHAR(50);

    SELECT @CourierID = courier_id, @NewDeliveryStatus = delivery_status FROM inserted;

    -- Check if the delivery_status is changed to FINISHED
    IF @NewDeliveryStatus = 'DELIVERED'
    BEGIN
        -- Update order_status in OrderTable to FINISHED
        UPDATE OrderTable
        SET order_status = 'FINISHED'
        WHERE courier_id = @CourierID;
    END;
END;
GO

CREATE TRIGGER UpdatePaymentStatus
ON OrderTable
AFTER UPDATE
AS
BEGIN
    SET NOCOUNT ON;

    -- Check if order_status is changed to FINISHED
    IF UPDATE(order_status) 
    BEGIN
        DECLARE @OrderID INT;
        DECLARE @NewOrderStatus VARCHAR(50);

        -- Get the order_id and new order_status
        SELECT @OrderID = i.order_id,
               @NewOrderStatus = i.order_status
        FROM inserted i;

        -- Check if the new order_status is FINISHED
        IF @NewOrderStatus = 'FINISHED'
        BEGIN
            -- Update payment_status to 'PAID' for cash payments
            UPDATE Payments
            SET payment_status = 'PAID'
            WHERE payment_id IN (SELECT payment_id FROM OrderTable WHERE order_id = @OrderID AND payment_method = 'CASH');
        END;
    END;
END;
GO