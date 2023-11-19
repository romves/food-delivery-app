/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FoodDelivery.dao;

import FoodDelivery.database.DatabaseUtility;
import FoodDelivery.models.Order;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kenzie Taqiyassar
 */
public class OrderDAO {

    private Connection connection;

    public OrderDAO() {
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

    public void addOrder(Order order) {
        String query = "INSERT INTO OrderTable (order_date, order_status, order_total, user_id, payment_id, courier_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setTimestamp(1, order.getOrderDate());
            preparedStatement.setString(2, order.getOrderStatus());
            preparedStatement.setDouble(3, order.getOrderTotal());
            preparedStatement.setInt(4, order.getUserId());
            preparedStatement.setInt(5, order.getPaymentId());
            preparedStatement.setInt(6, order.getCourierId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public int createOrderFromPayment(int paymentID, int userID, int restaurantID) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        int orderID = -1; // Initialize with a default value

        try {
            // Mengambil koneksi dari DatabaseUtility
            connection = DatabaseUtility.getConnection();

            // Membuat pemanggilan prosedur penyimpanan
            String storedProcedureCall = "{call CreateOrderFromPayment(?, ?, ?, ?)}";
            callableStatement = connection.prepareCall(storedProcedureCall);

            // Menetapkan parameter
            callableStatement.setInt(1, paymentID);
            callableStatement.setInt(2, userID);
            callableStatement.setInt(3, restaurantID);

            // Menambahkan parameter output untuk order_id
            callableStatement.registerOutParameter(4, Types.INTEGER);

            // Menjalankan pemanggilan prosedur penyimpanan
            callableStatement.execute();

            // Mendapatkan nilai order_id dari parameter output
            orderID = callableStatement.getInt(4);

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception as needed
        } finally {
            // Menutup koneksi dan pernyataan setelah selesai
            try {
                if (callableStatement != null) {
                    callableStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                // Handle exception as needed
            }
        }

        return orderID;
    }

    public Order getOrderById(int orderId) {
        String query = "SELECT * FROM OrderTable WHERE order_id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, orderId);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Order order = new Order(
                        resultSet.getInt("order_id"),
                        resultSet.getTimestamp("order_date"),
                        resultSet.getString("order_status"),
                        resultSet.getDouble("order_total"),
                        resultSet.getInt("user_id"),
                        resultSet.getInt("payment_id"),
                        resultSet.getInt("courier_id")
                );
                return order;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }

    public List<Order> getAllOrdersByUser(int userId) {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM OrderTable WHERE user_id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Order order = new Order(
                        resultSet.getInt("order_id"),
                        resultSet.getTimestamp("order_date"),
                        resultSet.getString("order_status"),
                        resultSet.getDouble("order_total"),
                        resultSet.getInt("user_id"),
                        resultSet.getInt("payment_id"),
                        resultSet.getInt("courier_id")
                );
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return orders;
    }
}
