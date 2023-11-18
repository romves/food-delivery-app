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

    public int createOrderFromPayment(int paymentId) {
        int newOrderId = 0;
        try {
            // Prepare the stored procedure call
            try (CallableStatement callableStatement = connection.prepareCall("{call CreateOrderFromPayment(?)}")) {
                // Set the input parameter
                callableStatement.setInt(1, paymentId);

                // Execute the stored procedure
                callableStatement.execute();

                // Retrieve the output parameter or result set, if any
                // For example, if the stored procedure returns the new order ID, you can do:
                newOrderId = callableStatement.getInt("NewOrderID");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately in your application
        }

        return newOrderId;
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
