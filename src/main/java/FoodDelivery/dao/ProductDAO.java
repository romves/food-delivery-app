/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FoodDelivery.dao;

import FoodDelivery.database.DatabaseUtility;
import FoodDelivery.models.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class ProductDAO {

    private Connection connection;

    public ProductDAO() {
        try {
            this.connection = DatabaseUtility.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            this.connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addProduct(Product product, String restaurant_id) {
        String query = "INSERT INTO Restaurant (product_name, product_price, product_type, restaurant_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setString(3, product.getType());
            preparedStatement.setString(4, restaurant_id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public Product getProductById(int productId) {
        String query = "SELECT * FROM Products where product_id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setInt(1, productId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product(
                        resultSet.getInt("product_id"),
                        resultSet.getString("product_name"),
                        resultSet.getDouble("product_price"),
                        resultSet.getString("product_type"),
                        resultSet.getInt("stock")
                );
                return product;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Product> getAllProductsByResto(int restoId) {
        ArrayList<Product> products = new ArrayList<>();
        String query = "SELECT * FROM Products where restaurant_id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setInt(1, restoId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product(
                        resultSet.getInt("product_id"),
                        resultSet.getString("product_name"),
                        resultSet.getDouble("product_price"),
                        resultSet.getString("product_type"),
                        resultSet.getInt("stock")
                );
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public void updateProducts(String courierId, String newStatus) {
        String query = "UPDATE Products SET delivery_status = ? WHERE courier_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, newStatus);
            preparedStatement.setString(2, courierId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void deleteProducts(String productId) {
        String query = "DELETE Products WHERE product_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, productId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public ArrayList<Product> getTop3FrequentlyBoughtTogetherProducts(int productId) {
        ArrayList<Product> topProducts = new ArrayList<>();
        String query = "SELECT TOP 3 od.product_id, p.product_name, p.product_price, p.product_type, p.stock, COUNT(od.product_id) as freq "
                + "FROM OrderDetails od "
                + "JOIN Products p ON od.product_id = p.product_id "
                + "WHERE od.order_id IN ( "
                + "    SELECT order_id FROM OrderDetails WHERE product_id = ? "
                + ") "
                + "AND od.product_id != ? "
                + "GROUP BY od.product_id, p.product_name, p.product_price, p.product_type, p.stock "
                + "ORDER BY freq DESC";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, productId);
            preparedStatement.setInt(2, productId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product(
                        resultSet.getInt("product_id"),
                        resultSet.getString("product_name"),
                        resultSet.getDouble("product_price"),
                        resultSet.getString("product_type"),
                        resultSet.getInt("stock")
                );
                topProducts.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return topProducts;
    }

    void updateStock(int stock, int product_id) {
        String query = "UPDATE Products SET stock = ? WHERE product_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, stock);
            preparedStatement.setInt(2, product_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Product> getTopSellingProducts(int restoId) {
        ArrayList<Product> topProducts = new ArrayList<>();
        String sql = "select product_id, product_name, product_price, product_type, stock, sold from Top5SellingProductsByResto where restaurant_id= ? order by sold desc";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setInt(1, restoId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product(
                        resultSet.getInt("product_id"),
                        resultSet.getString("product_name"),
                        resultSet.getDouble("product_price"),
                        resultSet.getString("product_type"),
                        resultSet.getInt("stock")
                );
                topProducts.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return topProducts;
    }

}
