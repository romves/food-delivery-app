
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
    restaurant_balance DECIMAL(10, 2) DEFAULT 0.0,
    CHECK (LEN(restaurant_name) > 0)
);


CREATE TABLE Products (
    product_id INT PRIMARY KEY IDENTITY(1,1),
    product_name VARCHAR(255) NOT NULL,
    product_price DECIMAL(10, 2) NOT NULL,
    product_type VARCHAR(10) CHECK (product_type IN ('Food', 'Drink')),
	stock INT DEFAULT 0,
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
    courier_status VARCHAR(50) NOT NULL CHECK (courier_status IN ('AVAILABLE', 'ON_DELIVERY' ,'DELIVERED')) DEFAULT 'AVAILABLE',
    courier_name VARCHAR(255) NOT NULL,
    courier_phone_number VARCHAR(20) UNIQUE NOT NULL,
    courier_plate_number VARCHAR(20) UNIQUE NOT NULL,
	balance DECIMAL(10, 2) DEFAULT 0.0,
    CHECK (LEN(courier_name) > 0)
);

CREATE TABLE OrderTable (
    order_id INT PRIMARY KEY IDENTITY(1,1),
    order_date DATETIME DEFAULT GETDATE() ,
    order_status VARCHAR(50) CHECK (order_status IN ('PENDING', 'ON_PROCESS', 'FINISHED')) DEFAULT 'PENDING',
    order_total DECIMAL(10,2),
	shipping_cost DECIMAL(10, 2) DEFAULT 10000,
    user_id INT,
    payment_id INT,
    courier_id INT,
	restaurant_id INT,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (payment_id) REFERENCES Payments(payment_id),
    FOREIGN KEY (courier_id) REFERENCES Couriers(courier_id),
	FOREIGN KEY (restaurant_id) REFERENCES Restaurant(restaurant_id)
);
CREATE TABLE OrderDetails (
    order_id INT,
    product_id INT,
    quantity INT NOT NULL,
    PRIMARY KEY (order_id, product_id),
    CHECK (quantity > 0),
    FOREIGN KEY (order_id) REFERENCES OrderTable(order_id),
    FOREIGN KEY (product_id) REFERENCES Products(product_id)
);
GO


-- Trigger to update subtotal in OrderDetails when a new product is added
CREATE TRIGGER UpdateSubtotalAndTotal
ON OrderDetails
AFTER INSERT, UPDATE, DELETE
AS
BEGIN
    SET NOCOUNT ON;

    -- Update order_total in OrderTable for all affected orders
    UPDATE ot
    SET ot.order_total = ISNULL((SELECT SUM(p.product_price * i.quantity)
                                FROM OrderDetails od
                                INNER JOIN inserted i ON od.product_id = i.product_id
                                INNER JOIN Products p ON i.product_id = p.product_id
                                WHERE od.order_id = ot.order_id), 0)
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

    SELECT @CourierID = courier_id, @NewDeliveryStatus = courier_status FROM inserted;

    -- Check if the courier_status is changed to FINISHED
    IF @NewDeliveryStatus = 'DELIVERED'
    BEGIN
        -- Update order_status in OrderTable to FINISHED
        UPDATE OrderTable
        SET order_status = 'FINISHED'
        WHERE courier_id = @CourierID;
    END;
END;
GO





GO

-- Trigger to update delivery_status to 'PENDING' when order_status is FINISHED
CREATE TRIGGER UpdateCourierDeliveryStatus
ON OrderTable
AFTER UPDATE
AS
BEGIN
    SET NOCOUNT ON;

    -- Check if order_status is changed to FINISHED
    IF UPDATE(order_status) 
    BEGIN
        DECLARE @CourierID INT;
        DECLARE @NewOrderStatus VARCHAR(50);

        -- Get the courier_id and new order_status
        SELECT @CourierID = i.courier_id,
               @NewOrderStatus = i.order_status
        FROM inserted i;

        -- Check if the new order_status is FINISHED
        IF @NewOrderStatus = 'FINISHED'
        BEGIN
            -- Update delivery_status to 'PENDING' for the courier
            UPDATE Couriers
            SET courier_status = 'AVAILABLE'
            WHERE courier_id = @CourierID;
        END;
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

CREATE VIEW TopRestaurantsView AS
WITH TopRestaurantsCTE AS (
    SELECT
        r.restaurant_id,
        r.restaurant_name,
        SUM(p.product_price * od.quantity) AS total_sales
    FROM
        OrderTable ot
        JOIN OrderDetails od ON ot.order_id = od.order_id
        JOIN Products p ON od.product_id = p.product_id
        JOIN Restaurant r ON p.restaurant_id = r.restaurant_id
    WHERE
        ot.order_status = 'FINISHED'
        AND ot.order_date >= DATEADD(day, -10, GETDATE())
    GROUP BY
        r.restaurant_id, r.restaurant_name
)
SELECT
    restaurant_id,
    restaurant_name,
    total_sales
FROM TopRestaurantsCTE;
GO

CREATE PROCEDURE CreateOrderFromPayment
    @PaymentID INT,
	@UserID INT,
	@RestaurantID INT
AS
BEGIN
    BEGIN TRANSACTION; -- Start the transaction

    BEGIN TRY
        -- Insert a new order with the provided payment ID
        INSERT INTO OrderTable (order_date, order_status, payment_id,user_id,restaurant_id)
        VALUES (GETDATE(), 'PENDING', @PaymentID,@UserID,@RestaurantID);

        -- Get the newly created order ID
        DECLARE @OrderID INT;
        SET @OrderID = SCOPE_IDENTITY();

        -- Update the payment status to 'PAID' for non-cash payments
        UPDATE Payments
        SET payment_status = 'PAID'
        WHERE payment_id = @PaymentID
          AND payment_method <> 'CASH';

        -- Update the new order's status to 'ON_PROCESS' if payment_method is not null
        UPDATE OrderTable
        SET order_status = 'ON_PROCESS'
        WHERE order_id = @OrderID
          AND EXISTS (
              SELECT 1
              FROM Payments
              WHERE payment_id = @PaymentID
                AND payment_method IS NOT NULL
          );

        COMMIT; -- Commit the transaction if all statements succeed
    END TRY
    BEGIN CATCH
        ROLLBACK; -- Roll back the transaction if an error occurs
        -- Handle the error as needed (log, re-throw, etc.)
        THROW;
    END CATCH;
END;
