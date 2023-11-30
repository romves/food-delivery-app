
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


DECLARE @paymentId1 INT, @paymentId2 INT, @paymentId3 INT, @paymentId4 INT, @paymentId5 INT,
        @paymentId6 INT, @paymentId7 INT, @paymentId8 INT, @paymentId9 INT, @paymentId10 INT;
DECLARE @orderId1 INT, @orderId2 INT, @orderId3 INT, @orderId4 INT, @orderId5 INT,
        @orderId6 INT, @orderId7 INT, @orderId8 INT, @orderId9 INT, @orderId10 INT;
DECLARE @courierID1 INT, @courierID2 INT, @courierID3 INT, @courierID4 INT, @courierID5 INT,
        @courierID6 INT, @courierID7 INT, @courierID8 INT, @courierID9 INT, @courierID10 INT;

DECLARE @PaymentOutput1 TABLE (payment_id INT);
DECLARE @PaymentOutput2 TABLE (payment_id INT);
DECLARE @PaymentOutput3 TABLE (payment_id INT);
DECLARE @PaymentOutput4 TABLE (payment_id INT);
DECLARE @PaymentOutput5 TABLE (payment_id INT);
DECLARE @PaymentOutput6 TABLE (payment_id INT);
DECLARE @PaymentOutput7 TABLE (payment_id INT);
DECLARE @PaymentOutput8 TABLE (payment_id INT);
DECLARE @PaymentOutput9 TABLE (payment_id INT);
DECLARE @PaymentOutput10 TABLE (payment_id INT);

DECLARE @OrderOutput1 TABLE (order_id INT);
DECLARE @OrderOutput2 TABLE (order_id INT);
DECLARE @OrderOutput3 TABLE (order_id INT);
DECLARE @OrderOutput4 TABLE (order_id INT);
DECLARE @OrderOutput5 TABLE (order_id INT);
DECLARE @OrderOutput6 TABLE (order_id INT);
DECLARE @OrderOutput7 TABLE (order_id INT);
DECLARE @OrderOutput8 TABLE (order_id INT);
DECLARE @OrderOutput9 TABLE (order_id INT);
DECLARE @OrderOutput10 TABLE (order_id INT);

INSERT INTO Payments (payment_status, payment_method)
OUTPUT inserted.payment_id INTO @PaymentOutput1
VALUES ('PAID', 'CC');
SELECT @paymentId1 = payment_id FROM @PaymentOutput1;
INSERT INTO OrderTable(user_id, restaurant_id, payment_id)
OUTPUT inserted.order_id INTO @OrderOutput1
VALUES (1, 1, @paymentId1);
SELECT @orderId1 = order_id FROM @OrderOutput1;
INSERT INTO OrderDetails (order_id, product_id, quantity)
VALUES
    (@orderId1, 1, 3),
    (@orderId1, 2, 6),
    (@orderId1, 3, 3),
    (@orderId1, 4, 2),
    (@orderId1, 5, 2),
    (@orderId1, 6, 3),
    (@orderId1, 7, 6);
EXEC AssignCourierToOrder @orderId1, @courierID1 OUTPUT;
UPDATE OrderTable
SET courier_id = @courierID1
WHERE order_id = @orderId1;

INSERT INTO Payments (payment_status, payment_method)
OUTPUT inserted.payment_id INTO @PaymentOutput2
VALUES ('PAID', 'DANA');

SELECT @paymentId2 = payment_id FROM @PaymentOutput2;

INSERT INTO OrderTable(user_id, restaurant_id, payment_id)
OUTPUT inserted.order_id INTO @OrderOutput2
VALUES (2, 2, @paymentId2);

SELECT @orderId2 = order_id FROM @OrderOutput2;

INSERT INTO OrderDetails (order_id, product_id, quantity)
VALUES
    -- Order 2 (Same Restaurant - Seafood Paradise)
    (@orderId2, 8, 4),
    (@orderId2, 10, 7),
    (@orderId2, 11, 2),
    (@orderId2, 12, 2),
    (@orderId2, 13, 3),
    (@orderId2, 14, 2);

EXEC AssignCourierToOrder @orderId2, @courierID2 OUTPUT;
UPDATE OrderTable
SET courier_id = @courierID2
WHERE order_id = @orderId2;

INSERT INTO Payments (payment_status, payment_method)
OUTPUT inserted.payment_id INTO @PaymentOutput3
VALUES ('PAID', 'OVO');

SELECT @paymentId3 = payment_id FROM @PaymentOutput3;

INSERT INTO OrderTable(user_id, restaurant_id, payment_id)
OUTPUT inserted.order_id INTO @OrderOutput3
VALUES (3, 3, @paymentId3);

SELECT @orderId3 = order_id FROM @OrderOutput3;

INSERT INTO OrderDetails (order_id, product_id, quantity)
VALUES
    -- Order 3 (Same Restaurant - Cookingg Express)
    (@orderId3, 15, 5),
    (@orderId3, 17, 2),
    (@orderId3, 18, 5),
    (@orderId3, 19, 2),
    (@orderId3, 20, 4),
    (@orderId3, 21, 5);

EXEC AssignCourierToOrder @orderId3, @courierID3 OUTPUT;
UPDATE OrderTable
SET courier_id = @courierID3
WHERE order_id = @orderId3;

INSERT INTO Payments (payment_status, payment_method)
OUTPUT inserted.payment_id INTO @PaymentOutput4
VALUES ('PAID', 'CC');

SELECT @paymentId4 = payment_id FROM @PaymentOutput4;

INSERT INTO OrderTable(user_id, restaurant_id, payment_id)
OUTPUT inserted.order_id INTO @OrderOutput4
VALUES (4, 4, @paymentId4);

SELECT @orderId4 = order_id FROM @OrderOutput4;

INSERT INTO OrderDetails (order_id, product_id, quantity)
VALUES
    -- Order 4 (Same Restaurant - King Satay)
    (@orderId4, 22, 4),
    (@orderId4, 23, 4),
    (@orderId4, 24, 1),
    (@orderId4, 25, 1),
    (@orderId4, 27, 1),
    (@orderId4, 28, 5);

EXEC AssignCourierToOrder @orderId4, @courierID4 OUTPUT;
UPDATE OrderTable
SET courier_id = @courierID4
WHERE order_id = @orderId4;


INSERT INTO Payments (payment_status, payment_method)
OUTPUT inserted.payment_id INTO @PaymentOutput5
VALUES ('PAID', 'CC');

SELECT @paymentId5 = payment_id FROM @PaymentOutput5;

INSERT INTO OrderTable(user_id, restaurant_id, payment_id)
OUTPUT inserted.order_id INTO @OrderOutput5
VALUES (5, 5, @paymentId5);

SELECT @orderId5 = order_id FROM @OrderOutput5;


INSERT INTO OrderDetails (order_id, product_id, quantity)
VALUES
    -- Order 5 (Same Restaurant - Meat Ball Corner)
    (@orderId5, 29, 6),
    (@orderId5, 30, 2),
    (@orderId5, 31, 4),
    (@orderId5, 33, 2),
    (@orderId5, 34, 3),
    (@orderId5, 35, 3);


EXEC AssignCourierToOrder @orderId5, @courierID5 OUTPUT;
UPDATE OrderTable
SET courier_id = @courierID5
WHERE order_id = @orderId5;

INSERT INTO Payments (payment_status, payment_method)
OUTPUT inserted.payment_id INTO @PaymentOutput6
VALUES ('PAID', 'CC');

SELECT @paymentId6 = payment_id FROM @PaymentOutput6;

INSERT INTO OrderTable(user_id, restaurant_id, payment_id)
OUTPUT inserted.order_id INTO @OrderOutput6
VALUES (6, 6, @paymentId6);


SELECT @orderId6 = order_id FROM @OrderOutput6;

-- 
INSERT INTO OrderDetails (order_id, product_id, quantity)
VALUES
    -- Order 6 (Same Restaurant - Heaven Cook Resto)
    (@orderId6, 36, 3),
    (@orderId6, 37, 2),
    (@orderId6, 38, 2),
    (@orderId6, 39, 1),
    (@orderId6, 41, 4),
    (@orderId6, 42, 2);

EXEC AssignCourierToOrder @orderId6, @courierID6 OUTPUT;
UPDATE OrderTable
SET courier_id = @courierID6
WHERE order_id = @orderId6;

INSERT INTO Payments (payment_status, payment_method)
OUTPUT inserted.payment_id INTO @PaymentOutput7
VALUES ('PAID', 'CC');

SELECT @paymentId7 = payment_id FROM @PaymentOutput7;

INSERT INTO OrderTable(user_id, restaurant_id, payment_id)
OUTPUT inserted.order_id INTO @OrderOutput7
VALUES (7, 7, @paymentId7);

SELECT @orderId7 = order_id FROM @OrderOutput7;


INSERT INTO OrderDetails (order_id, product_id, quantity)
VALUES
    -- Order 7 (Same Restaurant - Chicken Heritage)
    (@orderId7, 43, 4),
    (@orderId7, 44, 3),
    (@orderId7, 45, 3),
    (@orderId7, 46, 1),
    (@orderId7, 48, 4),
    (@orderId7, 49, 3);


EXEC AssignCourierToOrder @orderId7, @courierID7 OUTPUT;
UPDATE OrderTable
SET courier_id = @courierID7
WHERE order_id = @orderId7;

INSERT INTO Payments (payment_status, payment_method)
OUTPUT inserted.payment_id INTO @PaymentOutput8
VALUES ('PAID', 'CC');


SELECT @paymentId8 = payment_id FROM @PaymentOutput8;

INSERT INTO OrderTable(user_id, restaurant_id, payment_id)
OUTPUT inserted.order_id INTO @OrderOutput8
VALUES (8, 8, @paymentId8);

SELECT @orderId8 = order_id FROM @OrderOutput8;

INSERT INTO OrderDetails (order_id, product_id, quantity)
VALUES
    -- Order 8 (Same Restaurant - Steak Palace)
    (@orderId8, 50, 3),
    (@orderId8, 51, 3),
    (@orderId8, 52, 2),
    (@orderId8, 53, 1),
    (@orderId8, 54, 1),
    (@orderId8, 55, 6),
    (@orderId8, 56, 3);

EXEC AssignCourierToOrder @orderId8, @courierID8 OUTPUT;
UPDATE OrderTable
SET courier_id = @courierID8
WHERE order_id = @orderId8;

INSERT INTO Payments (payment_status, payment_method)
OUTPUT inserted.payment_id INTO @PaymentOutput9
VALUES ('PAID', 'CC');

SELECT @paymentId9 = payment_id FROM @PaymentOutput9;

INSERT INTO OrderTable(user_id, restaurant_id, payment_id)
OUTPUT inserted.order_id INTO @OrderOutput9
VALUES (9, 9, @paymentId9);

SELECT @orderId9 = order_id FROM @OrderOutput9;

INSERT INTO OrderDetails (order_id, product_id, quantity)
VALUES
    -- Order 9 (Same Restaurant - Meat and Spicy Lovers)
    (@orderId9, 57, 3),
    (@orderId9, 58, 1),
    (@orderId9, 59, 1),
    (@orderId9, 60, 2),
    (@orderId9, 61, 2),
    (@orderId9, 62, 3),
    (@orderId9, 63, 3);

EXEC AssignCourierToOrder @orderId9, @courierID9 OUTPUT;
UPDATE OrderTable
SET courier_id = @courierID9
WHERE order_id = @orderId9;

INSERT INTO Payments (payment_status, payment_method)
OUTPUT inserted.payment_id INTO @PaymentOutput10
VALUES ('PAID', 'CC');
SELECT @paymentId10 = payment_id FROM @PaymentOutput10;
INSERT INTO OrderTable(user_id, restaurant_id, payment_id)
OUTPUT inserted.order_id INTO @OrderOutput10
VALUES (10, 10, @paymentId10);
SELECT @orderId10 = order_id FROM @OrderOutput10;
INSERT INTO OrderDetails (order_id, product_id, quantity)
VALUES
    -- Order 10 (Same Restaurant - Cheff Garden)
    (@orderId10, 64, 6),
    (@orderId10, 65, 1),
    (@orderId10, 66, 1),
    (@orderId10, 67, 2),
    (@orderId10, 68, 1),
    (@orderId10, 69, 3),
    (@orderId10, 70, 2);

EXEC AssignCourierToOrder @orderId10, @courierID10 OUTPUT;
UPDATE OrderTable
SET courier_id = @courierID10
WHERE order_id = @orderId10;

UPDATE Couriers
SET courier_status='DELIVERED'
WHERE courier_id=1;
UPDATE Couriers
SET courier_status = 'DELIVERED'
WHERE courier_id = 2;
UPDATE Couriers
SET courier_status = 'DELIVERED'
WHERE courier_id = 3;
UPDATE Couriers
SET courier_status = 'DELIVERED'
WHERE courier_id = 4;
UPDATE Couriers
SET courier_status = 'DELIVERED'
WHERE courier_id = 5;
UPDATE Couriers
SET courier_status = 'DELIVERED'
WHERE courier_id = 6;
UPDATE Couriers
SET courier_status = 'DELIVERED'
WHERE courier_id = 7;

UPDATE Couriers
SET courier_status = 'DELIVERED'
WHERE courier_id = 8;

UPDATE Couriers
SET courier_status = 'DELIVERED'
WHERE courier_id = 9;

UPDATE Couriers
SET courier_status = 'DELIVERED'
WHERE courier_id = 10;

UPDATE OrderTable
SET order_status = 'FINISHED'
WHERE order_id = 1;

UPDATE OrderTable
SET order_status = 'FINISHED'
WHERE order_id = 2;

UPDATE OrderTable
SET order_status = 'FINISHED'
WHERE order_id = 3;

UPDATE OrderTable
SET order_status = 'FINISHED'
WHERE order_id = 4;

UPDATE OrderTable
SET order_status = 'FINISHED'
WHERE order_id = 5;

UPDATE OrderTable
SET order_status = 'FINISHED'
WHERE order_id = 6;

UPDATE OrderTable
SET order_status = 'FINISHED'
WHERE order_id = 7;

UPDATE OrderTable
SET order_status = 'FINISHED'
WHERE order_id = 8;

UPDATE OrderTable
SET order_status = 'FINISHED'
WHERE order_id = 9;

UPDATE OrderTable
SET order_status = 'FINISHED'
WHERE order_id = 10;


UPDATE Couriers
SET courier_status = 'AVAILABLE'
WHERE courier_id = 1;

UPDATE Couriers
SET courier_status = 'AVAILABLE'
WHERE courier_id = 2;

UPDATE Couriers
SET courier_status = 'AVAILABLE'
WHERE courier_id = 3;

UPDATE Couriers
SET courier_status = 'AVAILABLE'
WHERE courier_id = 4;

UPDATE Couriers
SET courier_status = 'AVAILABLE'
WHERE courier_id = 5;

UPDATE Couriers
SET courier_status = 'AVAILABLE'
WHERE courier_id = 6;

UPDATE Couriers
SET courier_status = 'AVAILABLE'
WHERE courier_id = 7;

UPDATE Couriers
SET courier_status = 'AVAILABLE'
WHERE courier_id = 8;

UPDATE Couriers
SET courier_status = 'AVAILABLE'
WHERE courier_id = 9;

UPDATE Couriers
SET courier_status = 'AVAILABLE'
WHERE courier_id = 10;



DECLARE @paymentId11 INT, @paymentId12 INT, @paymentId13 INT, @paymentId14 INT, @paymentId15 INT;
DECLARE @orderId11 INT, @orderId12 INT, @orderId13 INT, @orderId14 INT, @orderId15 INT;
DECLARE @courierID11 INT, @courierID12 INT, @courierID13 INT, @courierID14 INT, @courierID15 INT;

DECLARE @PaymentOutput11 TABLE (payment_id INT);
DECLARE @PaymentOutput12 TABLE (payment_id INT);
DECLARE @PaymentOutput13 TABLE (payment_id INT);
DECLARE @PaymentOutput14 TABLE (payment_id INT);
DECLARE @PaymentOutput15 TABLE (payment_id INT);

DECLARE @OrderOutput11 TABLE (order_id INT);
DECLARE @OrderOutput12 TABLE (order_id INT);
DECLARE @OrderOutput13 TABLE (order_id INT);
DECLARE @OrderOutput14 TABLE (order_id INT);
DECLARE @OrderOutput15 TABLE (order_id INT);

INSERT INTO Payments (payment_status, payment_method)
OUTPUT inserted.payment_id INTO @PaymentOutput11
VALUES ('PAID', 'CC');

SELECT @paymentId11 = payment_id FROM @PaymentOutput11;

INSERT INTO OrderTable(user_id, restaurant_id, payment_id)
OUTPUT inserted.order_id INTO @OrderOutput11
VALUES (1, 1, @paymentId11);

SELECT @orderId11 = order_id FROM @OrderOutput11;

INSERT INTO OrderDetails (order_id, product_id, quantity)
VALUES
    (@orderId11, 1, 4),
    (@orderId11, 2, 1),
    (@orderId11, 3, 3),
    (@orderId11, 7, 2);

EXEC AssignCourierToOrder @orderId11, @courierID11 OUTPUT;
UPDATE OrderTable
SET courier_id = @courierID11
WHERE order_id = @orderId11;

INSERT INTO Payments (payment_status, payment_method)
OUTPUT inserted.payment_id INTO @PaymentOutput12
VALUES ('PAID', 'DANA');

SELECT @paymentId12 = payment_id FROM @PaymentOutput12;

INSERT INTO OrderTable(user_id, restaurant_id, payment_id)
OUTPUT inserted.order_id INTO @OrderOutput12
VALUES (2, 2, @paymentId12);

SELECT @orderId12 = order_id FROM @OrderOutput12;

INSERT INTO OrderDetails (order_id, product_id, quantity)
VALUES
    ( @orderId12, 8, 3),
    ( @orderId12, 10, 2),
    ( @orderId12, 13, 2),
    ( @orderId12, 14, 1);

EXEC AssignCourierToOrder @orderId12, @courierID12 OUTPUT;
UPDATE OrderTable
SET courier_id = @courierID12
WHERE order_id = @orderId12;

UPDATE Couriers
SET courier_status = 'DELIVERED'
WHERE courier_id = 11;

UPDATE Couriers
SET courier_status = 'DELIVERED'
WHERE courier_id = 12;

UPDATE OrderTable
SET order_status = 'FINISHED'
WHERE order_id = 11;

UPDATE OrderTable
SET order_status = 'FINISHED'
WHERE order_id = 12;

UPDATE Couriers
SET courier_status = 'AVAILABLE'
WHERE courier_id = 11;

UPDATE Couriers
SET courier_status = 'AVAILABLE'
WHERE courier_id = 12;


use FoodDeliveryApp
	SELECT * FROM Users
	SELECT * FROM Restaurant
	SELECT * FROM Products
	SELECT * FROM Couriers
	SELECT * FROM OrderTable
	SELECT * FROM OrderDetails
	SELECT * FROM Payments
