use master
GO
USE FoodDeliveryApp
GO

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


INSERT INTO Products (product_name, product_price, product_type, stock, restaurant_id)
VALUES
    ('Special Fried Rice', 25000.00, 'Food', 50, 1),
    ('Crunchy Fried Chicken', 30000.00, 'Food', 50, 1),
    ('Madura Chicken Satay', 35000.00, 'Food', 50, 1),
    ('Padang Beef Rendang', 40000.00, 'Food', 50, 1),
    ('Vegetable Salad with Peanut Sauce', 20000.00, 'Food', 50, 1);

INSERT INTO Products (product_name, product_price, product_type, stock, restaurant_id)
VALUES
    ('Sweet Iced Tea', 5000.00, 'Drink', 50, 1),
    ('Avocado Juice', 10000.00, 'Drink', 50, 1);

INSERT INTO Products (product_name, product_price, product_type, stock, restaurant_id)
VALUES
    ('Grilled Prawns', 60000.00, 'Food', 50, 2),
    ('Fishermans Catch', 75000.00, 'Food', 50, 2),
    ('Garlic Butter Crab', 80000.00, 'Food', 50, 2),
    ('Spicy Seafood Soup', 45000.00, 'Food', 50, 2),
    ('Squid Ink Pasta', 35000.00, 'Food', 50, 2);

INSERT INTO Products (product_name, product_price, product_type, stock, restaurant_id)
VALUES
    ('Ocean Breeze Cooler', 12000.00, 'Drink', 50, 2),
    ('Tropical Sunset Mocktail', 15000.00, 'Drink', 50, 2);

INSERT INTO Products (product_name, product_price, product_type, stock, restaurant_id)
VALUES
    ('Special Fried Rice with Chicken', 28000.00, 'Food', 50, 3),
    ('Shrimp Fried Rice', 32000.00, 'Food', 50, 3),
    ('Vegetarian Fried Rice', 25000.00, 'Food', 50, 3),
    ('Spicy Chicken Noodles', 30000.00, 'Food', 50, 3),
    ('Nasi Goreng with Beef', 35000.00, 'Food', 50, 3);

INSERT INTO Products (product_name, product_price, product_type, stock, restaurant_id)
VALUES
    ('Iced Lemongrass Tea', 7000.00, 'Drink', 50, 3),
    ('Fresh Orange Juice', 12000.00, 'Drink', 50, 3);

INSERT INTO Products (product_name, product_price, product_type, stock, restaurant_id)
VALUES
    ('Lamb Satay Skewers', 40000.00, 'Food', 50, 4),
    ('Grilled Lamb Chops', 45000.00, 'Food', 50, 4),
    ('Spicy Lamb Soup', 35000.00, 'Food', 50, 4),
    ('Lamb Kofta Kebab', 38000.00, 'Food', 50, 4),
    ('Turmeric Marinated Lamb', 42000.00, 'Food', 50, 4);

INSERT INTO Products (product_name, product_price, product_type, stock, restaurant_id)
VALUES
    ('Mint Lemonade', 8000.00, 'Drink', 50, 4),
    ('Rosemary Infused Iced Tea', 10000.00, 'Drink', 50, 4);

INSERT INTO Products (product_name, product_price, product_type, stock, restaurant_id)
VALUES
    ('Beef Meatball Soup', 18000.00, 'Food', 50, 5),
    ('Chicken Noodle Soup', 15000.00, 'Food', 50, 5),
    ('Spicy Tofu Meatballs', 20000.00, 'Food', 50, 5),
    ('Bakso Special Mix', 25000.00, 'Food', 50, 5),
    ('Fried Wonton with Meatballs', 22000.00, 'Food', 50, 5);

INSERT INTO Products (product_name, product_price, product_type, stock, restaurant_id)
VALUES
    ('Hot Ginger Tea', 5000.00, 'Drink', 50, 5),
    ('Iced Lychee Punch', 10000.00, 'Drink', 50, 5);

INSERT INTO Products (product_name, product_price, product_type, stock, restaurant_id)
VALUES
    ('Chocolate Banana Martabak', 25000.00, 'Food', 50, 6),
    ('Cheese Pandan Martabak', 30000.00, 'Food', 50, 6),
    ('Strawberry Nutella Martabak', 35000.00, 'Food', 50, 6),
    ('Vanilla Almond Martabak', 28000.00, 'Food', 50, 6),
    ('Caramel Coconut Martabak', 32000.00, 'Food', 50, 6);

INSERT INTO Products (product_name, product_price, product_type, stock, restaurant_id)
VALUES
    ('Hot Chocolate', 7000.00, 'Drink', 50, 6),
    ('Iced Matcha Latte', 12000.00, 'Drink', 50, 6);

INSERT INTO Products (product_name, product_price, product_type, stock, restaurant_id)
VALUES
    ('Chicken Soto Soup', 18000.00, 'Food', 50, 7),
    ('Beef Soto Soup', 15000.00, 'Food', 50, 7),
    ('Vegetarian Soto', 20000.00, 'Food', 50, 7),
    ('Spicy Coconut Chicken Soup', 25000.00, 'Food', 50, 7),
    ('Soto Ayam Special', 22000.00, 'Food', 50, 7);

INSERT INTO Products (product_name, product_price, product_type, stock, restaurant_id)
VALUES
    ('Warm Ginger Elixir', 5000.00, 'Drink', 50, 7),
    ('Chrysanthemum Iced Tea', 10000.00, 'Drink', 50, 7);

INSERT INTO Products (product_name, product_price, product_type, stock, restaurant_id)
VALUES
    ('Beef Rendang', 25000.00, 'Food', 50, 8),
    ('Sambalado Fried Chicken', 30000.00, 'Food', 50, 8),
    ('Egg Rendang Sandwich', 35000.00, 'Food', 50, 8),
    ('Petai and Anchovies Stir-Fry', 28000.00, 'Food', 50, 8),
    ('Green Chili Beef Curry', 32000.00, 'Food', 50, 8);

INSERT INTO Products (product_name, product_price, product_type, stock, restaurant_id)
VALUES
    ('Turmeric Tamarind Cooler', 7000.00, 'Drink', 50, 8),
    ('Lime Basil Spritzer', 12000.00, 'Drink', 50, 8);

INSERT INTO Products (product_name, product_price, product_type, stock, restaurant_id)
VALUES
    ('Spicy Beef Rendang', 18000.00, 'Food', 50, 9),
    ('Fiery Chicken Vindaloo', 15000.00, 'Food', 50, 9),
    ('Hot and Spicy Sichuan Beef', 20000.00, 'Food', 50, 9),
    ('Spicy Cajun Blackened Steak', 25000.00, 'Food', 50, 9),
    ('Spicy Chicken Curry', 22000.00, 'Food', 50, 9);

INSERT INTO Products (product_name, product_price, product_type, stock, restaurant_id)
VALUES
    ('Iced Roselle Tea', 5000.00, 'Drink', 50, 9),
    ('Lychee Ginger Elixir', 10000.00, 'Drink', 50, 9);

INSERT INTO Products (product_name, product_price, product_type, stock, restaurant_id)
VALUES
    ('Vegetable Gado-Gado Salad', 20000.00, 'Food', 50, 10),
    ('Tofu and Tempeh Satay', 25000.00, 'Food', 50, 10),
    ('Avocado and Peanut Rice Bowl', 18000.00, 'Food', 50, 10),
    ('Balinese Spicy Vegetables', 22000.00, 'Food', 50, 10),
    ('Jicama and Cabbage Slaw', 18000.00, 'Food', 50, 10);

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

DECLARE @paymentId INT;
DECLARE @orderId INT;

-- Define table variables to capture the OUTPUT values
DECLARE @PaymentOutput TABLE (payment_id INT);
DECLARE @OrderOutput TABLE (order_id INT);
-- 1. Insert Payment
INSERT INTO Payments (payment_status, payment_method)
OUTPUT inserted.payment_id INTO @PaymentOutput
VALUES ('PAID', 'CC');

-- Retrieve the payment_id from the table variable
SELECT @paymentId = payment_id FROM @PaymentOutput;

-- 2. Insert Order from Payment
INSERT INTO OrderTable(user_id, restaurant_id, payment_id)
OUTPUT inserted.order_id INTO @OrderOutput
VALUES (1, 1, @paymentId);

-- Retrieve the order_id from the table variable
SELECT @orderId = order_id FROM @OrderOutput;

-- 3. Insert OrderDetails
INSERT INTO OrderDetails (order_id, product_id, quantity)
VALUES
    -- Order 1 (Same Restaurant - Hometown Restaurant)
    (@orderId, 1, 3),
    (@orderId, 2, 6),
    (@orderId, 3, 3),
    (@orderId, 4, 2),
    (@orderId, 5, 2),
    (@orderId, 6, 3),
    (@orderId, 7, 6);

DECLARE @courierID INT;
EXEC AssignCourierToOrder @OrderID, @courierID OUTPUT;
UPDATE OrderTable
SET courier_id = @courierID
WHERE order_id = @OrderID;
UPDATE Couriers
SET courier_status='DELIVERED';
UPDATE OrderTable
SET order_status = 'FINISHED';
UPDATE Couriers
SET courier_status='AVAILABLE';





use FoodDeliveryApp
	SELECT * FROM Users
	SELECT * FROM Restaurant
	SELECT * FROM Products
	SELECT * FROM Couriers
	SELECT * FROM OrderTable
	SELECT * FROM OrderDetails
	SELECT * FROM Payments
