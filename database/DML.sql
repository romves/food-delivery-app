use master
GO
USE FoodDeliveryApp
GO
-- Inserting sample data into Users table
INSERT INTO Users (user_name, user_email, user_address, user_phone_number, user_password)
VALUES
    ('Budi', 'budi@gmail.com', 'Street Cipto Mangunkusumo No. 123, Malang', '081234567890', 'Password123'),
    ('Siti', 'siti@gmail.com', 'Street Gajah Mada No. 456, Malang', '081345678901', 'SecurePass456'),
    ('Dewi', 'dewi@gmail.com', 'Street Sudirman No. 789, Malang', '081456789012', 'StrongPassword789'),
    ('Joko', 'joko@gmail.com', 'Street Merdeka No. 101, Malang', '081567890123', 'P@ssw0rd456'),
    ('Rini', 'rini@gmail.com', 'Street Pahlawan No. 202, Malang', '081678901234', 'SafeP@ss789'),
    ('Adi', 'adi@gmail.com', 'Street Diponegoro No. 303, Malang', '081789012345', '1234AdiPass'),
    ('Maya', 'maya@gmail.com', 'Street Asia Afrika No. 404, Malang', '081890123456', 'MayaP@ssword1'),
    ('Eko', 'eko@gmail.com', 'Street Hayam Wuruk No. 505, Malang', '081901234567', 'Eko1234Pass'),
    ('Dian', 'dian@gmail.com', 'Street Jend. Sudirman No. 606, Malang', '081012345678', 'DianSecurePass1'),
    ('Faisal', 'faisal@gmail.com', 'Street M.H. Thamrin No. 707, Malang', '081123456789', 'Faisal123Secure');

-- Inserting sample data into Restaurant table
INSERT INTO Restaurant (restaurant_name, restaurant_email, restaurant_password, restaurant_address, restaurant_description, restaurant_phone_number)
VALUES
    ('Hometown Restaurant', 'hometownrestaurant@example.com', 'HometownPass123', 'Street Pemuda No. 1, Malang', 'Authentic Indonesian cuisine', '081234567800'),
    ('Seafood Paradise', 'seafoodparadise@example.com', 'SeafoodPass456', 'Street Pantai Indah No. 2, Malang', 'Fresh seafood with a view', '081345678911'),
    ('Cookingg Express', 'cookingexpress@example.com', 'ExpressPass789', 'Street Merah Putih No. 3, Malang', 'Quick and delicious fried rice', '081456789022'),
    ('King Satay', 'kingsatay@example.com', 'KingSatayPass101', 'Street Hijau No. 4, Malang', 'The king of Authentic satay of Lamb', '081567890133'),
    ('Meat Ball Corner', 'meatballcorner@example.com', 'MeatBallPass202', 'Street Soehat No. 5, Malang', 'Delicious meatball soup', '081678901244'),
    ('Heaven Cook Resto', 'heavencookresto@example.com', 'HeavenCookPass303', 'Street Ijen No. 6, Malang', 'Sweet and savory pancakes', '081789012355'),
    ('Chicken Heritage', 'chickenheritage@example.com', 'ChickenPass404', 'Street Gurita No. 7, Malang', 'Traditional chicken and soup', '081890123466'),
    ('Steak Palace', 'steakpalace@example.com', 'SteakPass505', 'Street Cengger Ayam No. 8, Malang', 'processed meat of the best quality', '081901234577'),
    ('Meat and Spicy Lovers', 'meatandspicylovers@example.com', 'SpicyMeatPass606', 'Street Veteran No. 9, Malang', 'Spicy and flavorful beef dish', '081012345688'),
    ('Cheff Garden', 'cheffgarden@example.com', 'CheffGardenPass707', 'Street Garden No. 10, Malang', 'Vegetable salad with peanut sauce', '081123456799');

-- Inserting sample data into Products table

-- Foods for Hometown Restaurant
INSERT INTO Products (product_name, product_price, product_type, stock, restaurant_id)
VALUES
    ('Special Fried Rice', 25000.00, 'Food', 50, 1),
    ('Crunchy Fried Chicken', 30000.00, 'Food', 50, 1),
    ('Madura Chicken Satay', 35000.00, 'Food', 50, 1),
    ('Padang Beef Rendang', 40000.00, 'Food', 50, 1),
    ('Vegetable Salad with Peanut Sauce', 20000.00, 'Food', 50, 1);

-- Drinks for Hometown Restaurant
INSERT INTO Products (product_name, product_price, product_type, stock, restaurant_id)
VALUES
    ('Sweet Iced Tea', 5000.00, 'Drink', 50, 1),
    ('Avocado Juice', 10000.00, 'Drink', 50, 1);

-- Foods for Seafood Paradise
INSERT INTO Products (product_name, product_price, product_type, stock, restaurant_id)
VALUES
    ('Grilled Prawns', 60000.00, 'Food', 50, 2),
    ('Fishermans Catch', 75000.00, 'Food', 50, 2),
    ('Garlic Butter Crab', 80000.00, 'Food', 50, 2),
    ('Spicy Seafood Soup', 45000.00, 'Food', 50, 2),
    ('Squid Ink Pasta', 35000.00, 'Food', 50, 2);

-- Drinks for Seafood Paradise
INSERT INTO Products (product_name, product_price, product_type, stock, restaurant_id)
VALUES
    ('Ocean Breeze Cooler', 12000.00, 'Drink', 50, 2),
    ('Tropical Sunset Mocktail', 15000.00, 'Drink', 50, 2);

-- Foods for Cookingg Express
INSERT INTO Products (product_name, product_price, product_type, stock, restaurant_id)
VALUES
    ('Special Fried Rice with Chicken', 28000.00, 'Food', 50, 3),
    ('Shrimp Fried Rice', 32000.00, 'Food', 50, 3),
    ('Vegetarian Fried Rice', 25000.00, 'Food', 50, 3),
    ('Spicy Chicken Noodles', 30000.00, 'Food', 50, 3),
    ('Nasi Goreng with Beef', 35000.00, 'Food', 50, 3);

-- Drinks for Cookingg Express
INSERT INTO Products (product_name, product_price, product_type, stock, restaurant_id)
VALUES
    ('Iced Lemongrass Tea', 7000.00, 'Drink', 50, 3),
    ('Fresh Orange Juice', 12000.00, 'Drink', 50, 3);

-- Foods for Sate King Satay
INSERT INTO Products (product_name, product_price, product_type, stock, restaurant_id)
VALUES
    ('Lamb Satay Skewers', 40000.00, 'Food', 50, 4),
    ('Grilled Lamb Chops', 45000.00, 'Food', 50, 4),
    ('Spicy Lamb Soup', 35000.00, 'Food', 50, 4),
    ('Lamb Kofta Kebab', 38000.00, 'Food', 50, 4),
    ('Turmeric Marinated Lamb', 42000.00, 'Food', 50, 4);

-- Drinks for King Satay
INSERT INTO Products (product_name, product_price, product_type, stock, restaurant_id)
VALUES
    ('Mint Lemonade', 8000.00, 'Drink', 50, 4),
    ('Rosemary Infused Iced Tea', 10000.00, 'Drink', 50, 4);

-- Foods for Meat Ball Corner
INSERT INTO Products (product_name, product_price, product_type, stock, restaurant_id)
VALUES
    ('Beef Meatball Soup', 18000.00, 'Food', 50, 5),
    ('Chicken Noodle Soup', 15000.00, 'Food', 50, 5),
    ('Spicy Tofu Meatballs', 20000.00, 'Food', 50, 5),
    ('Bakso Special Mix', 25000.00, 'Food', 50, 5),
    ('Fried Wonton with Meatballs', 22000.00, 'Food', 50, 5);

-- Drinks for Meat Ball Corner
INSERT INTO Products (product_name, product_price, product_type, stock, restaurant_id)
VALUES
    ('Hot Ginger Tea', 5000.00, 'Drink', 50, 5),
    ('Iced Lychee Punch', 10000.00, 'Drink', 50, 5);

-- Foods for Heaven Cook Resto
INSERT INTO Products (product_name, product_price, product_type, stock, restaurant_id)
VALUES
    ('Chocolate Banana Martabak', 25000.00, 'Food', 50, 6),
    ('Cheese Pandan Martabak', 30000.00, 'Food', 50, 6),
    ('Strawberry Nutella Martabak', 35000.00, 'Food', 50, 6),
    ('Vanilla Almond Martabak', 28000.00, 'Food', 50, 6),
    ('Caramel Coconut Martabak', 32000.00, 'Food', 50, 6);

-- Drinks for Heaven Cook Resto
INSERT INTO Products (product_name, product_price, product_type, stock, restaurant_id)
VALUES
    ('Hot Chocolate', 7000.00, 'Drink', 50, 6),
    ('Iced Matcha Latte', 12000.00, 'Drink', 50, 6);

-- Foods for Chicken Heritage
INSERT INTO Products (product_name, product_price, product_type, stock, restaurant_id)
VALUES
    ('Chicken Soto Soup', 18000.00, 'Food', 50, 7),
    ('Beef Soto Soup', 15000.00, 'Food', 50, 7),
    ('Vegetarian Soto', 20000.00, 'Food', 50, 7),
    ('Spicy Coconut Chicken Soup', 25000.00, 'Food', 50, 7),
    ('Soto Ayam Special', 22000.00, 'Food', 50, 7);

-- Drinks for Chicken Heritage
INSERT INTO Products (product_name, product_price, product_type, stock, restaurant_id)
VALUES
    ('Warm Ginger Elixir', 5000.00, 'Drink', 50, 7),
    ('Chrysanthemum Iced Tea', 10000.00, 'Drink', 50, 7);

-- Foods for Steak Palace
INSERT INTO Products (product_name, product_price, product_type, stock, restaurant_id)
VALUES
    ('Beef Rendang', 25000.00, 'Food', 50, 8),
    ('Sambalado Fried Chicken', 30000.00, 'Food', 50, 8),
    ('Egg Rendang Sandwich', 35000.00, 'Food', 50, 8),
    ('Petai and Anchovies Stir-Fry', 28000.00, 'Food', 50, 8),
    ('Green Chili Beef Curry', 32000.00, 'Food', 50, 8);

-- Drinks for Steak Palace
INSERT INTO Products (product_name, product_price, product_type, stock, restaurant_id)
VALUES
    ('Turmeric Tamarind Cooler', 7000.00, 'Drink', 50, 8),
    ('Lime Basil Spritzer', 12000.00, 'Drink', 50, 8);

-- Foods for Meat and Spicy Lovers
INSERT INTO Products (product_name, product_price, product_type, stock, restaurant_id)
VALUES
    ('Spicy Beef Rendang', 18000.00, 'Food', 50, 9),
    ('Fiery Chicken Vindaloo', 15000.00, 'Food', 50, 9),
    ('Hot and Spicy Sichuan Beef', 20000.00, 'Food', 50, 9),
    ('Spicy Cajun Blackened Steak', 25000.00, 'Food', 50, 9),
    ('Spicy Chicken Curry', 22000.00, 'Food', 50, 9);

-- Drinks for Meat and Spicy Lovers
INSERT INTO Products (product_name, product_price, product_type, stock, restaurant_id)
VALUES
    ('Iced Roselle Tea', 5000.00, 'Drink', 50, 9),
    ('Lychee Ginger Elixir', 10000.00, 'Drink', 50, 9);

-- Foods for Cheff Garden
INSERT INTO Products (product_name, product_price, product_type, stock, restaurant_id)
VALUES
    ('Vegetable Gado-Gado Salad', 20000.00, 'Food', 50, 10),
    ('Tofu and Tempeh Satay', 25000.00, 'Food', 50, 10),
    ('Avocado and Peanut Rice Bowl', 18000.00, 'Food', 50, 10),
    ('Balinese Spicy Vegetables', 22000.00, 'Food', 50, 10),
    ('Jicama and Cabbage Slaw', 18000.00, 'Food', 50, 10);

-- Drinks for Cheff Garden
INSERT INTO Products (product_name, product_price, product_type, stock, restaurant_id)
VALUES
    ('Passionfruit Iced Tea', 6000.00, 'Drink', 50, 10),
    ('Mango Mint Refresher', 11000.00, 'Drink', 50, 10);


INSERT INTO Couriers (courier_name, courier_phone_number, courier_plate_number)
VALUES
    ('John Doe', '081234567890', 'H123XY'),
    ('Alice Smith', '081345678901', 'AB456CD'),
    ('Bob Johnson', '081456789012', 'EFG789H'),
    ('Emma Davis', '081567890123', 'JKL101M'),
    ('Ryan White', '081678901234', 'NOP112Q'),
    ('Linda Brown', '081789012345', 'RST223U'),
    ('Michael Clark', '081890123456', 'VWX334Y'),
    ('Sophia Lee', '081901234567', 'ZAB445P'),
    ('Daniel Kim', '081012345678', 'LMN556R'),
    ('Olivia Wang', '081123456789', 'OPQ667S');


GO
DECLARE @OrderID INT;
DECLARE @UserID INT = 1; -- Replace with the desired user ID
DECLARE @RestaurantID INT = 1; -- Replace with the desired restaurant ID

-- Create a new payment (replace with your actual payment details)
INSERT INTO Payments (payment_status, payment_method, payment_date)
VALUES ('UNPAID', 'CC', GETDATE());

-- Get the ID of the newly created payment
DECLARE @PaymentID INT = SCOPE_IDENTITY();

-- Execute the stored procedure to create an order from the payment
EXEC CreateOrderFromPayment @PaymentID, @UserID, @RestaurantID, @OrderID OUTPUT;

GO
DECLARE @OrderID INT;
DECLARE @UserID INT = 2; -- Replace with the desired user ID
DECLARE @RestaurantID INT = 2; -- Replace with the desired restaurant ID

-- Create a new payment (replace with your actual payment details)
INSERT INTO Payments (payment_status, payment_method, payment_date)
VALUES ('UNPAID', 'CC', GETDATE());

-- Get the ID of the newly created payment
DECLARE @PaymentID INT = SCOPE_IDENTITY();

-- Execute the stored procedure to create an order from the payment
EXEC CreateOrderFromPayment @PaymentID, @UserID, @RestaurantID, @OrderID OUTPUT;

GO
DECLARE @OrderID INT;
DECLARE @UserID INT = 3; -- Replace with the desired user ID
DECLARE @RestaurantID INT = 3; -- Replace with the desired restaurant ID

-- Create a new payment (replace with your actual payment details)
INSERT INTO Payments (payment_status, payment_method, payment_date)
VALUES ('UNPAID', 'CC', GETDATE());

-- Get the ID of the newly created payment
DECLARE @PaymentID INT = SCOPE_IDENTITY();

-- Execute the stored procedure to create an order from the payment
EXEC CreateOrderFromPayment @PaymentID, @UserID, @RestaurantID, @OrderID OUTPUT;

GO
DECLARE @OrderID INT;
DECLARE @UserID INT = 4; -- Replace with the desired user ID
DECLARE @RestaurantID INT = 4; -- Replace with the desired restaurant ID

-- Create a new payment (replace with your actual payment details)
INSERT INTO Payments (payment_status, payment_method, payment_date)
VALUES ('UNPAID', 'CC', GETDATE());

-- Get the ID of the newly created payment
DECLARE @PaymentID INT = SCOPE_IDENTITY();

-- Execute the stored procedure to create an order from the payment
EXEC CreateOrderFromPayment @PaymentID, @UserID, @RestaurantID, @OrderID OUTPUT;
GO
DECLARE @OrderID INT;
DECLARE @UserID INT = 5; -- Replace with the desired user ID
DECLARE @RestaurantID INT = 5; -- Replace with the desired restaurant ID

-- Create a new payment (replace with your actual payment details)
INSERT INTO Payments (payment_status, payment_method, payment_date)
VALUES ('UNPAID', 'CC', GETDATE());

-- Get the ID of the newly created payment
DECLARE @PaymentID INT = SCOPE_IDENTITY();

-- Execute the stored procedure to create an order from the payment
EXEC CreateOrderFromPayment @PaymentID, @UserID, @RestaurantID, @OrderID OUTPUT;


GO
DECLARE @OrderID INT;
DECLARE @UserID INT = 5; -- Replace with the desired user ID
DECLARE @RestaurantID INT = 5; -- Replace with the desired restaurant ID

-- Create a new payment (replace with your actual payment details)
INSERT INTO Payments (payment_status, payment_method, payment_date)
VALUES ('UNPAID', 'CC', GETDATE());

-- Get the ID of the newly created payment
DECLARE @PaymentID INT = SCOPE_IDENTITY();

-- Execute the stored procedure to create an order from the payment
EXEC CreateOrderFromPayment @PaymentID, @UserID, @RestaurantID, @OrderID OUTPUT;

GO
DECLARE @OrderID INT;
DECLARE @UserID INT = 6; -- Replace with the desired user ID
DECLARE @RestaurantID INT = 6; -- Replace with the desired restaurant ID

-- Create a new payment (replace with your actual payment details)
INSERT INTO Payments (payment_status, payment_method, payment_date)
VALUES ('UNPAID', 'CC', GETDATE());

-- Get the ID of the newly created payment
DECLARE @PaymentID INT = SCOPE_IDENTITY();

-- Execute the stored procedure to create an order from the payment
EXEC CreateOrderFromPayment @PaymentID, @UserID, @RestaurantID, @OrderID OUTPUT;

GO
DECLARE @OrderID INT;
DECLARE @UserID INT = 7; -- Replace with the desired user ID
DECLARE @RestaurantID INT = 7; -- Replace with the desired restaurant ID

-- Create a new payment (replace with your actual payment details)
INSERT INTO Payments (payment_status, payment_method, payment_date)
VALUES ('UNPAID', 'CC', GETDATE());

-- Get the ID of the newly created payment
DECLARE @PaymentID INT = SCOPE_IDENTITY();

-- Execute the stored procedure to create an order from the payment
EXEC CreateOrderFromPayment @PaymentID, @UserID, @RestaurantID, @OrderID OUTPUT;
-- Inserting sample data into OrderDetails table with at least two different products for each order

GO
DECLARE @OrderID INT;
DECLARE @UserID INT = 8; -- Replace with the desired user ID
DECLARE @RestaurantID INT = 8; -- Replace with the desired restaurant ID

-- Create a new payment (replace with your actual payment details)
INSERT INTO Payments (payment_status, payment_method, payment_date)
VALUES ('UNPAID', 'CC', GETDATE());

-- Get the ID of the newly created payment
DECLARE @PaymentID INT = SCOPE_IDENTITY();

-- Execute the stored procedure to create an order from the payment
EXEC CreateOrderFromPayment @PaymentID, @UserID, @RestaurantID, @OrderID OUTPUT;

GO
DECLARE @OrderID INT;
DECLARE @UserID INT = 9; -- Replace with the desired user ID
DECLARE @RestaurantID INT = 9; -- Replace with the desired restaurant ID

-- Create a new payment (replace with your actual payment details)
INSERT INTO Payments (payment_status, payment_method, payment_date)
VALUES ('UNPAID', 'CC', GETDATE());

-- Get the ID of the newly created payment
DECLARE @PaymentID INT = SCOPE_IDENTITY();

-- Execute the stored procedure to create an order from the payment
EXEC CreateOrderFromPayment @PaymentID, @UserID, @RestaurantID, @OrderID OUTPUT;

GO
DECLARE @OrderID INT;
DECLARE @UserID INT = 10; -- Replace with the desired user ID
DECLARE @RestaurantID INT = 10; -- Replace with the desired restaurant ID

-- Create a new payment (replace with your actual payment details)
INSERT INTO Payments (payment_status, payment_method, payment_date)
VALUES ('UNPAID', 'CC', GETDATE());

-- Get the ID of the newly created payment
DECLARE @PaymentID INT = SCOPE_IDENTITY();

-- Execute the stored procedure to create an order from the payment
EXEC CreateOrderFromPayment @PaymentID, @UserID, @RestaurantID, @OrderID OUTPUT;
INSERT INTO OrderDetails (order_id, product_id, quantity)
VALUES
    -- Order 1 (Same Restaurant - Hometown Restaurant)
    (1, 1, 3),
    (1, 2, 6),
	(1, 3, 3),
	(1, 4, 2),
    (1, 5, 2),
    (1, 6, 3),
	(1, 7, 6),
	
    -- Order 2 (Same Restaurant - Seafood Paradise)
    (2, 8, 4),
    (2, 10, 7),
    (2, 11, 2),
    (2, 12, 2),
	(2, 13, 3),
    (2, 14, 2),

    -- Order 3 (Same Restaurant - Cookingg Express)
    (3, 15, 5),
    (3, 17, 2),
	(3, 18, 5),
    (3, 19, 2),
    (3, 20, 4),
    (3, 21, 5),

    -- Order 4 (Same Restaurant - King Satay)
    (4, 22, 4),
    (4, 23, 4),
	(4, 24, 1),
    (4, 25, 1),
	(4, 27, 1),
    (4, 28, 5),

    -- Order 5 (Same Restaurant - Meat Ball Corner)
    (5, 29, 6),
    (5, 30, 2),
	(5, 31, 4),
    (5, 33, 2),
	(5, 34, 3),
    (5, 35, 3),

    -- Order 6 (Same Restaurant - Heaven Cook Resto)
    (6, 36, 3),
	(6, 37, 2),
	(6, 38, 2),
	(6, 39, 1),
    (6, 41, 4),
    (6, 42, 2),

    -- Order 7 (Same Restaurant - Chicken Heritage)
    (7, 43, 4),
	(7, 44, 3),
	(7, 45, 3),
	(7, 46, 1),
    (7, 48, 4),
    (7, 49, 3),

    -- Order 8 (Same Restaurant - Steak Palace)
    (8, 50, 3),
	(8, 51, 3),
	(8, 52, 2),
	(8, 53, 1),
	(8, 54, 1),
	(8, 55, 6),
    (8, 56, 3),

    -- Order 9 (Same Restaurant - Meat and Spicy Lovers)
    (9, 57, 3),
    (9, 58, 1),
	(9, 59, 1),
	(9, 60, 2),
	(9, 61, 2),
	(9, 62, 3),
    (9, 63, 3),

    -- Order 10 (Same Restaurant - Cheff Garden)
    (10, 64, 6),
	(10, 65, 1),
    (10, 66, 1),
	(10, 67, 2),
	(10, 68, 1),
	(10, 69, 3),
    (10, 70, 2);
GO

DECLARE @OrderID1 INT = 1;
DECLARE @CourierID1 INT;

-- Execute the stored procedure
EXEC AssignCourierToOrder
    @OrderID = @OrderID1,
    @CourierID = @CourierID1 OUTPUT;

DECLARE @OrderID2 INT = 2;
DECLARE @CourierID2 INT;

-- Execute the stored procedure
EXEC AssignCourierToOrder
    @OrderID = @OrderID2,
    @CourierID = @CourierID2 OUTPUT;

DECLARE @OrderID3 INT = 3;
DECLARE @CourierID3 INT;

-- Execute the stored procedure
EXEC AssignCourierToOrder
    @OrderID = @OrderID3,
    @CourierID = @CourierID3 OUTPUT;

DECLARE @OrderID4 INT = 4;
DECLARE @CourierID4 INT;

-- Execute the stored procedure
EXEC AssignCourierToOrder
    @OrderID = @OrderID4,
    @CourierID = @CourierID4 OUTPUT;

DECLARE @OrderID5 INT = 5;
DECLARE @CourierID5 INT;

-- Execute the stored procedure
EXEC AssignCourierToOrder
    @OrderID = @OrderID5,
    @CourierID = @CourierID5 OUTPUT;

DECLARE @OrderID6 INT = 6;
DECLARE @CourierID6 INT;

-- Execute the stored procedure
EXEC AssignCourierToOrder
    @OrderID = @OrderID6,
    @CourierID = @CourierID6 OUTPUT;

DECLARE @OrderID7 INT = 7;
DECLARE @CourierID7 INT;

-- Execute the stored procedure
EXEC AssignCourierToOrder
    @OrderID = @OrderID7,
    @CourierID = @CourierID7 OUTPUT;

DECLARE @OrderID8 INT = 8;
DECLARE @CourierID8 INT;

-- Execute the stored procedure
EXEC AssignCourierToOrder
    @OrderID = @OrderID8,
    @CourierID = @CourierID8 OUTPUT;

DECLARE @OrderID9 INT = 9;
DECLARE @CourierID9 INT;

-- Execute the stored procedure
EXEC AssignCourierToOrder
    @OrderID = @OrderID9,
    @CourierID = @CourierID9 OUTPUT;

DECLARE @OrderID10 INT = 10;
DECLARE @CourierID10 INT;

-- Execute the stored procedure
EXEC AssignCourierToOrder
    @OrderID = @OrderID10,
    @CourierID = @CourierID10 OUTPUT;

GO

UPDATE Couriers SET courier_status='DELIVERED'
UPDATE OrderTable SET order_status='FINISHED'
UPDATE Couriers SET courier_status='AVAILABLE'

use FoodDeliveryApp
	SELECT * FROM Users
	SELECT * FROM Restaurant
	SELECT * FROM Products
	SELECT * FROM Couriers
	SELECT * FROM OrderTable
	SELECT * FROM OrderDetails
	SELECT * FROM Payments
