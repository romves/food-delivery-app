use master
drop database FoodDeliveryApp
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
	@RestaurantID INT,
    @OrderID INT OUTPUT
AS
BEGIN
    BEGIN TRANSACTION; -- Start the transaction

    BEGIN TRY
        -- Insert a new order with the provided payment ID
        INSERT INTO OrderTable (order_date, order_status, payment_id, user_id, restaurant_id)
        VALUES (GETDATE(), 'PENDING', @PaymentID, @UserID, @RestaurantID);

        -- Get the newly created order ID
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
GO
CREATE PROCEDURE AssignCourierToOrder
    @OrderID INT,
    @CourierID INT OUTPUT
AS
BEGIN
    BEGIN TRANSACTION; 

    BEGIN TRY
        SELECT TOP 1
            @CourierID = courier_id
        FROM
            Couriers
        WHERE
            courier_status = 'AVAILABLE'
        ORDER BY
            (SELECT COUNT(*) FROM OrderTable WHERE courier_id = Couriers.courier_id) ASC;

        IF @CourierID IS NOT NULL
        BEGIN
            UPDATE OrderTable
            SET courier_id = @CourierID,
                order_status = 'ON_PROCESS'
            WHERE
                order_id = @OrderID;
            UPDATE Couriers
            SET courier_status = 'ON_DELIVERY'
            WHERE
                courier_id = @CourierID;
        END
        ELSE
        BEGIN
            PRINT 'ALL COURIERS ARE BUSY. PLEASE TRY AGAIN IN A FEW MINUTES.';
            ROLLBACK;
            RETURN;
        END

        COMMIT; 
    END TRY
    BEGIN CATCH
        ROLLBACK; 
        THROW;
    END CATCH;
END;
GO

CREATE TRIGGER UpdateOrderTotal 
ON OrderTable 
AFTER UPDATE, INSERT
AS
BEGIN
    update ot
    set order_total = ISNULL((select SUM(p.product_price) 
                            from OrderDetails od 
                            join Products p on od.product_id=p.product_id 
                            where od.order_id = ot.order_id), 0)
    FROM OrderTable ot
END
GO

CREATE TRIGGER UpdateCourierBalanceAndOrderStatus
ON OrderTable
AFTER UPDATE
AS
BEGIN
    IF UPDATE(order_status)
    BEGIN
        DECLARE @CourierID INT, @ShippingCost DECIMAL(10, 2);

        SELECT
            @CourierID = i.courier_id,
            @ShippingCost = i.shipping_cost
        FROM
            inserted i
            JOIN deleted d ON i.order_id = d.order_id
            JOIN Couriers c ON i.courier_id = c.courier_id
        WHERE
            i.order_status = 'FINISHED' AND d.order_status = 'ON_PROCESS';

        IF @CourierID IS NOT NULL
        BEGIN
            UPDATE Couriers
            SET balance = balance + @ShippingCost
            WHERE courier_id = @CourierID;
        END
    END
END;
GO