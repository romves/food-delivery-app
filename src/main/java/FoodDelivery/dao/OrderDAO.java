/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FoodDelivery.dao;

import FoodDelivery.database.DatabaseUtility;
import FoodDelivery.models.Order;
import FoodDelivery.models.OrderDetail;
import FoodDelivery.models.Product;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        int orderID = -1;
        try {
            connection = DatabaseUtility.getConnection();
            String storedProcedureCall = "{call CreateOrderFromPayment(?, ?, ?, ?)}";
            callableStatement = connection.prepareCall(storedProcedureCall);
            callableStatement.setInt(1, paymentID);
            callableStatement.setInt(2, userID);
            callableStatement.setInt(3, restaurantID);
            callableStatement.registerOutParameter(4, Types.INTEGER);
            callableStatement.execute();
            orderID = callableStatement.getInt(4);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (callableStatement != null) {
                    callableStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
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
//            closeConnection();
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

    public void deleteOrderById(int orderId) {
        String DELETE_ORDER_QUERY = "DELETE FROM OrderTable WHERE order_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ORDER_QUERY)) {
            preparedStatement.setInt(1, orderId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            resetOrderIdentity();
        }
    }

    public void resetOrderIdentity() {
        String RESET_IDENTITY_QUERY = "DBCC CHECKIDENT('OrderTable', RESEED)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(RESET_IDENTITY_QUERY)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void cancelOrder(int orderId) {
        String UPDATE_STATUS_QUERY = "UPDATE OrderTable SET order_status = 'CANCELED' WHERE order_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STATUS_QUERY)) {
            preparedStatement.setInt(1, orderId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
//            closeConnection();
        }
    }

    public void setOrderStatusFinished(int orderId) {
        String UPDATE_STATUS_QUERY = "UPDATE OrderTable SET order_status = 'FINISHED' WHERE order_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STATUS_QUERY)) {
            preparedStatement.setInt(1, orderId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
//            closeConnection();
        }
    }

    public String getOrderStatus(int orderId) {
        String sql = "SELECT order_status FROM OrderTable WHERE order_id = ?";
        try (Connection connection = DatabaseUtility.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, orderId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString("order_status");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
        return "";
    }

    public int getOrderIDFromPayment(int paymentId) {
        String GET_ORDER_ID_FROM_PAYMENT_QUERY = "SELECT order_id FROM OrderTable WHERE payment_id = ?";

        try (Connection connection = DatabaseUtility.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(GET_ORDER_ID_FROM_PAYMENT_QUERY)) {
            preparedStatement.setInt(1, paymentId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("order_id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
        return -1; // Order not found or payment not associated with an order
    }

    public Map<String, Integer> createOrder(int userId, int restaurantId,
            String paymentStatus, String paymentMethod, List<OrderDetail> orderDetails) {
        Map<String, Integer> generatedIds = new HashMap<>();
        try {
            connection = DatabaseUtility.getConnection();
            connection.setAutoCommit(false);
            PaymentDAO paymentDAO = new PaymentDAO();
            int paymentId = paymentDAO.insertPayment(paymentStatus, paymentMethod);
            int orderId = createOrderFromPayment(paymentId, userId, restaurantId);
            for (OrderDetail orderDetail : orderDetails) {
                OrderDetailDAO detailDAO = new OrderDetailDAO();
                ProductDAO productDB = new ProductDAO();
                Product product = productDB.getProductById(orderId);
                int productStock = product.getStock();
                int productQty = orderDetail.getQuantity();
                detailDAO.insertOrderDetail(orderId, orderDetail.getProductId(), orderDetail.getQuantity());
            }
            if (!getOrderStatus(orderId).equals("PENDING")) {

            }
            generatedIds.put("userId", userId);
            generatedIds.put("orderId", orderId);
            generatedIds.put("restaurantId", restaurantId);
            generatedIds.put("paymentId", paymentId);
//            generatedIds.put("courierId", courierId);
            connection.commit();
        } catch (SQLException e) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException rollbackException) {
                rollbackException.printStackTrace();
                System.out.println("Order Failed");
            }
            e.printStackTrace();
        } finally {
//            closeConnection();
        }
        return generatedIds;
    }

    public void setOrderStatusOnProcess(int orderId) {
        String query = "UPDATE OrderTable SET order_status = 'ON_PROCESS' WHERE order_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, orderId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
