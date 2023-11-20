/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FoodDelivery.dao;

import FoodDelivery.database.DatabaseUtility;
import FoodDelivery.models.OrderDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Kenzie Taqiyassar
 */
public class OrderDetailDAO {

    private Connection connection;

    public OrderDetailDAO() {
        try {
            connection = DatabaseUtility.getConnection();
        } catch (Exception e) {
        }
    }



//    public void checkDetail(int orderId, int productId, int quantity) {
//        try (Connection connection = DatabaseUtility.getConnection()) {
//            // Check if the record already exists
//            String checkIfExistsQuery = "SELECT * FROM OrderDetails WHERE order_id = ? AND product_id = ?";
//            try (PreparedStatement checkIfExistsStatement = connection.prepareStatement(checkIfExistsQuery)) {
//                checkIfExistsStatement.setInt(1, orderId);
//                checkIfExistsStatement.setInt(2, productId);
//
//                try (ResultSet resultSet = checkIfExistsStatement.executeQuery()) {
//                    if (resultSet.next()) {
//                        // If the record already exists, update it or delete if quantity is 0
//                        if (quantity > 0) {
//                            updateOrderDetail(orderId, productId, quantity);
//                        } else {
//                            deleteOrderDetail(orderId, productId);
//                        }
//                    } else {
//                        // If the record doesn't exist and quantity is greater than 0, insert a new one
//                        if (quantity > 0) {
//                            insertOrderDetail(orderId, productId, quantity);
//                        }
//                    }
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public void insertOrderDetail(int orderId, int productId, int quantity) {
        try (Connection connection = DatabaseUtility.getConnection()) {
            String insertQuery = "INSERT INTO OrderDetails (order_id, product_id, quantity) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setInt(1, orderId);
                preparedStatement.setInt(2, productId);
                preparedStatement.setInt(3, quantity);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateOrderDetail(int orderId, int productId, int quantity) {
        try (Connection connection = DatabaseUtility.getConnection()) {
            String updateQuery = "UPDATE OrderDetails SET quantity = ? WHERE order_id = ? AND product_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                preparedStatement.setInt(1, quantity);
                preparedStatement.setInt(2, orderId);
                preparedStatement.setInt(3, productId);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteOrderDetail(int orderId, int productId) {
        try (Connection connection = DatabaseUtility.getConnection()) {
            String deleteQuery = "DELETE FROM OrderDetails WHERE order_id = ? AND product_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                preparedStatement.setInt(1, orderId);
                preparedStatement.setInt(2, productId);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteOrderDetailByOrderId(int orderId) {
        String DELETE_ORDER_DETAIL_QUERY = "DELETE FROM OrderDetails WHERE order_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ORDER_DETAIL_QUERY)) {
            preparedStatement.setInt(1, orderId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
    }

}
