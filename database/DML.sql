USE FoodDeliveryApp
GO
-- Inserting sample data into Users table
INSERT INTO Users (user_name, user_email, user_address, user_phone_number, user_password)
VALUES
    ('Budi', 'budi@gmail.com', 'Jl. Cipto Mangunkusumo No. 123, Malang', '081234567890', 'Password123'),
    ('Siti', 'siti@gmail.com', 'Jl. Gajah Mada No. 456, Malang', '081345678901', 'SecurePass456'),
    ('Dewi', 'dewi@gmail.com', 'Jl. Sudirman No. 789, Malang', '081456789012', 'StrongPassword789'),
    ('Joko', 'joko@gmail.com', 'Jl. Merdeka No. 101, Malang', '081567890123', 'P@ssw0rd456'),
    ('Rini', 'rini@gmail.com', 'Jl. Pahlawan No. 202, Malang', '081678901234', 'SafeP@ss789'),
    ('Adi', 'adi@gmail.com', 'Jl. Diponegoro No. 303, Malang', '081789012345', '1234AdiPass'),
    ('Maya', 'maya@gmail.com', 'Jl. Asia Afrika No. 404, Malang', '081890123456', 'MayaP@ssword1'),
    ('Eko', 'eko@gmail.com', 'Jl. Hayam Wuruk No. 505, Malang', '081901234567', 'Eko1234Pass'),
    ('Dian', 'dian@gmail.com', 'Jl. Jend. Sudirman No. 606, Malang', '081012345678', 'DianSecurePass1'),
    ('Faisal', 'faisal@gmail.com', 'Jl. M.H. Thamrin No. 707, Malang', '081123456789', 'Faisal123Secure');

-- Inserting sample data into Restaurant table
INSERT INTO Restaurant (restaurant_name, restaurant_email, restaurant_password, restaurant_address, restaurant_description, restaurant_phone_number)
VALUES
    ('Warung Makan Sederhana', 'warungsederhana@example.com', 'WarungPass123', 'Jl. Pemuda No. 1, Malang', 'Authentic Indonesian cuisine', '081234567800'),
    ('Seafood Paradise', 'seafoodparadise@example.com', 'SeafoodPass456', 'Jl. Pantai Indah No. 2, Malang', 'Fresh seafood with a view', '081345678911'),
    ('Nasi Goreng Express', 'nasigorengexpress@example.com', 'NasiGorengPass789', 'Jl. Merah Putih No. 3, Malang', 'Quick and delicious fried rice', '081456789022'),
    ('Sate Kambing King', 'satekambingking@example.com', 'SateKingPass101', 'Jl. Hijau No. 4, Malang', 'The king of lamb satay', '081567890133'),
    ('Bakso Enak Corner', 'baksoenakcorner@example.com', 'BaksoPass202', 'Jl. Kenyal No. 5, Malang', 'Delicious meatball soup', '081678901244'),
    ('Martabak Manis Heaven', 'martabakmanisheaven@example.com', 'MartabakPass303', 'Jl. Manis No. 6, Malang', 'Sweet and savory pancakes', '081789012355'),
    ('Soto Ayam Heritage', 'sotoayamheritage@example.com', 'SotoAyamPass404', 'Jl. Heritage No. 7, Malang', 'Traditional chicken soup', '081890123466'),
    ('Padang Rendang Palace', 'padangrendangpalace@example.com', 'RendangPass505', 'Jl. Rendang No. 8, Malang', 'Spicy and flavorful beef dish', '081901234577'),
    ('Pecel Lele Lovers', 'pecellelelovers@example.com', 'PecelLelePass606', 'Jl. Lele No. 9, Malang', 'Crunchy fried catfish', '081012345688'),
    ('Gado-Gado Garden', 'gadogadogarden@example.com', 'GadoGadoPass707', 'Jl. Garden No. 10, Malang', 'Vegetable salad with peanut sauce', '081123456799');

-- Inserting sample data into Products table

INSERT INTO Products (product_name, product_price, product_type, restaurant_id)
VALUES
    ('Special Fried Rice', 25000.00, 'Food', 1),
    ('Crunchy Fried Chicken', 30000.00, 'Food', 1),
    ('Madura Chicken Satay', 35000.00, 'Food', 1),
    ('Padang Beef Rendang', 40000.00, 'Food', 1),
    ('Vegetable Salad with Peanut Sauce', 20000.00, 'Food', 1);

-- Drinks for Warung Makan Sederhana
INSERT INTO Products (product_name, product_price, product_type, restaurant_id)
VALUES
    ('Sweet Iced Tea', 5000.00, 'Drink', 1),
    ('Avocado Juice', 10000.00, 'Drink', 1);
INSERT INTO Products (product_name, product_price, product_type, restaurant_id)
VALUES
    ('Grilled Prawns', 60000.00, 'Food', 2),
    ('Fishermans Catch', 75000.00, 'Food', 2),
    ('Garlic Butter Crab', 80000.00, 'Food', 2),
    ('Spicy Seafood Soup', 45000.00, 'Food', 2),
    ('Squid Ink Pasta', 35000.00, 'Food', 2);

INSERT INTO Products (product_name, product_price, product_type, restaurant_id)
VALUES
    ('Ocean Breeze Cooler', 12000.00, 'Drink', 2),
    ('Tropical Sunset Mocktail', 15000.00, 'Drink', 2);

-- Foods for Nasi Goreng Express
INSERT INTO Products (product_name, product_price, product_type, restaurant_id)
VALUES
    ('Special Fried Rice with Chicken', 28000.00, 'Food', 3),
    ('Shrimp Fried Rice', 32000.00, 'Food', 3),
    ('Vegetarian Fried Rice', 25000.00, 'Food', 3),
    ('Spicy Chicken Noodles', 30000.00, 'Food', 3),
    ('Nasi Goreng with Beef', 35000.00, 'Food', 3);

-- Drinks for Nasi Goreng Express
INSERT INTO Products (product_name, product_price, product_type, restaurant_id)
VALUES
    ('Iced Lemongrass Tea', 7000.00, 'Drink', 3),
    ('Fresh Orange Juice', 12000.00, 'Drink', 3);

-- Foods for Sate Kambing King
INSERT INTO Products (product_name, product_price, product_type, restaurant_id)
VALUES
    ('Lamb Satay Skewers', 40000.00, 'Food', 4),
    ('Grilled Lamb Chops', 45000.00, 'Food', 4),
    ('Spicy Lamb Soup', 35000.00, 'Food', 4),
    ('Lamb Kofta Kebab', 38000.00, 'Food', 4),
    ('Turmeric Marinated Lamb', 42000.00, 'Food', 4);

-- Drinks for Sate Kambing King
INSERT INTO Products (product_name, product_price, product_type, restaurant_id)
VALUES
    ('Mint Lemonade', 8000.00, 'Drink', 4),
    ('Rosemary Infused Iced Tea', 10000.00, 'Drink', 4);

-- Foods for Bakso Enak Corner
INSERT INTO Products (product_name, product_price, product_type, restaurant_id)
VALUES
    ('Beef Meatball Soup', 18000.00, 'Food', 5),
    ('Chicken Noodle Soup', 15000.00, 'Food', 5),
    ('Spicy Tofu Meatballs', 20000.00, 'Food', 5),
    ('Bakso Special Mix', 25000.00, 'Food', 5),
    ('Fried Wonton with Meatballs', 22000.00, 'Food', 5);

-- Drinks for Bakso Enak Corner
INSERT INTO Products (product_name, product_price, product_type, restaurant_id)
VALUES
    ('Hot Ginger Tea', 5000.00, 'Drink', 5),
    ('Iced Lychee Punch', 10000.00, 'Drink', 5);

-- Foods for Martabak Manis Heaven
INSERT INTO Products (product_name, product_price, product_type, restaurant_id)
VALUES
    ('Chocolate Banana Martabak', 25000.00, 'Food', 6),
    ('Cheese Pandan Martabak', 30000.00, 'Food', 6),
    ('Strawberry Nutella Martabak', 35000.00, 'Food', 6),
    ('Vanilla Almond Martabak', 28000.00, 'Food', 6),
    ('Caramel Coconut Martabak', 32000.00, 'Food', 6);

-- Drinks for Martabak Manis Heaven
INSERT INTO Products (product_name, product_price, product_type, restaurant_id)
VALUES
    ('Hot Chocolate', 7000.00, 'Drink', 6),
    ('Iced Matcha Latte', 12000.00, 'Drink', 6);

-- Foods for Soto Ayam Heritage
INSERT INTO Products (product_name, product_price, product_type, restaurant_id)
VALUES
    ('Chicken Soto Soup', 18000.00, 'Food', 7),
    ('Beef Soto Soup', 15000.00, 'Food', 7),
    ('Vegetarian Soto', 20000.00, 'Food', 7),
    ('Spicy Coconut Chicken Soup', 25000.00, 'Food', 7),
    ('Soto Ayam Special', 22000.00, 'Food', 7);

-- Drinks for Soto Ayam Heritage
INSERT INTO Products (product_name, product_price, product_type, restaurant_id)
VALUES
    ('Warm Ginger Elixir', 5000.00, 'Drink', 7),
    ('Chrysanthemum Iced Tea', 10000.00, 'Drink', 7);

-- Foods for Padang Rendang Palace
INSERT INTO Products (product_name, product_price, product_type, restaurant_id)
VALUES
    ('Beef Rendang', 25000.00, 'Food', 8),
    ('Sambalado Fried Chicken', 30000.00, 'Food', 8),
    ('Egg Rendang Sandwich', 35000.00, 'Food', 8),
    ('Petai and Anchovies Stir-Fry', 28000.00, 'Food', 8),
    ('Green Chili Beef Curry', 32000.00, 'Food', 8);

-- Drinks for Padang Rendang Palace
INSERT INTO Products (product_name, product_price, product_type, restaurant_id)
VALUES
    ('Turmeric Tamarind Cooler', 7000.00, 'Drink', 8),
    ('Lime Basil Spritzer', 12000.00, 'Drink', 8);

-- Foods for Pecel Lele Lovers
INSERT INTO Products (product_name, product_price, product_type, restaurant_id)
VALUES
    ('Fried Catfish with Sambal', 18000.00, 'Food', 9),
    ('Grilled Lemongrass Catfish', 15000.00, 'Food', 9),
    ('Spicy Lime Leaf Catfish', 20000.00, 'Food', 9),
    ('Pecel Lele Platter', 25000.00, 'Food', 9),
    ('Crispy Catfish Skin', 22000.00, 'Food', 9);

-- Drinks for Pecel Lele Lovers
INSERT INTO Products (product_name, product_price, product_type, restaurant_id)
VALUES
    ('Iced Roselle Tea', 5000.00, 'Drink', 9),
    ('Lychee Ginger Elixir', 10000.00, 'Drink', 9);

-- Foods for Gado-Gado Garden
INSERT INTO Products (product_name, product_price, product_type, restaurant_id)
VALUES
    ('Vegetable Gado-Gado Salad', 20000.00, 'Food', 10),
    ('Tofu and Tempeh Satay', 25000.00, 'Food', 10),
    ('Avocado and Peanut Rice Bowl', 18000.00, 'Food', 10),
    ('Balinese Spicy Vegetables', 22000.00, 'Food', 10),
    ('Jicama and Cabbage Slaw', 18000.00, 'Food', 10);

-- Drinks for Gado-Gado Garden
INSERT INTO Products (product_name, product_price, product_type, restaurant_id)
VALUES
    ('Passionfruit Iced Tea', 6000.00, 'Drink', 10),
    ('Mango Mint Refresher', 11000.00, 'Drink', 10);

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


-- Inserting sample data into OrderTable table without payment_id
INSERT INTO OrderTable (order_date, order_status, user_id, courier_id)
VALUES
    (GETDATE(), 'PENDING', 1, 1),
    (GETDATE(), 'PENDING', 2, 2),
    (GETDATE(), 'PENDING', 3, 3),
    (GETDATE(), 'PENDING', 4, 4),
    (GETDATE(), 'PENDING', 5, 5),
    (GETDATE(), 'PENDING', 6, 6),
    (GETDATE(), 'PENDING', 7, 7),
    (GETDATE(), 'PENDING', 8, 8),
    (GETDATE(), 'PENDING', 9, 9),
    (GETDATE(), 'PENDING', 10, 10);

-- Inserting sample data into OrderDetails table with at least two different products for each order
INSERT INTO OrderDetails (order_id, product_id, quantity,subtotal)
VALUES
    -- Order 1 (Same Restaurant - Warung Makan Sederhana)
    (1, 1, 2,0.0),
    (1, 2, 1,0.0),


    -- Order 2 (Same Restaurant - Seafood Paradise)
    (2, 3, 3, 0),
    (2, 4, 2, 0),

    -- Order 3 (Same Restaurant - Nasi Goreng Express)
    (3, 5, 1, 0),
    (3, 6, 1, 0),

    -- Order 4 (Same Restaurant - Sate Kambing King)
    (4, 7, 1, 0),
    (4, 8, 1, 0),

    -- Order 5 (Same Restaurant - Bakso Enak Corner)
    (5, 9, 1, 0),
    (5, 10, 1, 0),

    -- Order 6 (Same Restaurant - Martabak Manis Heaven)
    (6, 11, 1, 0),
    (6, 12, 1, 0),

    -- Order 7 (Same Restaurant - Soto Ayam Heritage)
    (7, 13, 1, 0),
    (7, 14, 1, 0),

    -- Order 8 (Same Restaurant - Padang Rendang Palace)
    (8, 15, 1, 0),
    (8, 16, 1, 0),

    -- Order 9 (Same Restaurant - Pecel Lele Lovers)
    (9, 17, 1, 0),
    (9, 18, 1, 0),

    -- Order 10 (Same Restaurant - Gado-Gado Garden)
    (10, 19, 1, 0),
    (10, 20, 1, 0);

-- Inserting sample data into Payment table
INSERT INTO Payments (payment_status, payment_date,payment_method)
VALUES
    ('PAID',GETDATE(), 'CC'),
    ('UNPAID',GETDATE(), 'CASH'),
    ('PAID',GETDATE(), 'OVO'),
    ('PAID',GETDATE(), 'OVO'),
    ('PAID',GETDATE(), 'DANA'),
    ('PAID',GETDATE(), 'CC'),
    ('UNPAID',GETDATE(), 'CASH'),
    ('PAID',GETDATE(), 'DANA'),
    ('PAID',GETDATE(), 'OVO'),
    ('PAID',GETDATE(), 'CC');


-- Update OrderTable with payment_id
UPDATE OrderTable
SET payment_id = 1
WHERE order_id = 1;

UPDATE OrderTable
SET payment_id = 2
WHERE order_id = 2;

UPDATE OrderTable
SET payment_id = 3
WHERE order_id = 3;

UPDATE OrderTable
SET payment_id = 4
WHERE order_id = 4;

UPDATE OrderTable
SET payment_id = 5
WHERE order_id = 5;

UPDATE OrderTable
SET payment_id = 6
WHERE order_id = 6;

UPDATE OrderTable
SET payment_id = 7
WHERE order_id = 7;

UPDATE OrderTable
SET payment_id = 8
WHERE order_id = 8;

UPDATE OrderTable
SET payment_id = 9
WHERE order_id = 9;

UPDATE OrderTable
SET payment_id = 10
WHERE order_id = 10;


-- Update OrderTable to set order_status to FINISHED
UPDATE Couriers
SET delivery_status = 'DELIVERED'
FROM Couriers c
INNER JOIN OrderTable ot ON c.courier_id = ot.courier_id
WHERE ot.order_id = 1;
UPDATE Couriers
SET delivery_status = 'DELIVERED'
FROM Couriers c
INNER JOIN OrderTable ot ON c.courier_id = ot.courier_id
WHERE ot.order_id = 2;
UPDATE Couriers
SET delivery_status = 'DELIVERED'
FROM Couriers c
INNER JOIN OrderTable ot ON c.courier_id = ot.courier_id
WHERE ot.order_id = 3;
UPDATE Couriers
SET delivery_status = 'DELIVERED'
FROM Couriers c
INNER JOIN OrderTable ot ON c.courier_id = ot.courier_id
WHERE ot.order_id = 4;
UPDATE Couriers
SET delivery_status = 'DELIVERED'
FROM Couriers c
INNER JOIN OrderTable ot ON c.courier_id = ot.courier_id
WHERE ot.order_id = 5;
UPDATE Couriers
SET delivery_status = 'DELIVERED'
FROM Couriers c
INNER JOIN OrderTable ot ON c.courier_id = ot.courier_id
WHERE ot.order_id = 6;
UPDATE Couriers
SET delivery_status = 'DELIVERED'
FROM Couriers c
INNER JOIN OrderTable ot ON c.courier_id = ot.courier_id
WHERE ot.order_id = 7;
UPDATE Couriers
SET delivery_status = 'DELIVERED'
FROM Couriers c
INNER JOIN OrderTable ot ON c.courier_id = ot.courier_id
WHERE ot.order_id = 8;
UPDATE Couriers
SET delivery_status = 'DELIVERED'
FROM Couriers c
INNER JOIN OrderTable ot ON c.courier_id = ot.courier_id
WHERE ot.order_id = 9;
UPDATE Couriers
SET delivery_status = 'DELIVERED'
FROM Couriers c
INNER JOIN OrderTable ot ON c.courier_id = ot.courier_id
WHERE ot.order_id = 10;

SELECT*FROM Users
SELECT*FROM Restaurant
SELECT*FROM Products
SELECT*FROM Couriers
SELECT*FROM OrderTable
SELECT * FROM OrderDetails
SELECT * FROM Payments






