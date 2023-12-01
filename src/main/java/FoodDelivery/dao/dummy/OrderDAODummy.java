package FoodDelivery.dao.dummy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import FoodDelivery.database.DatabaseUtility;

public class OrderDAODummy {
    private Connection connection;

    public OrderDAODummy() {
        try {
            this.connection = DatabaseUtility.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createOrder(String orderStatus, int userId, int productId, int quantity,
            String paymentStatus, String paymentMethod) {
        try {
            int courierId = getAvailableCourierId();
            
            // Inserting order information into OrderTable
            int newOrderId = insertOrder(orderStatus, userId, courierId);

            // Inserting order details into OrderDetails
            insertOrderDetails(newOrderId, productId, quantity);

            // Inserting payment information into Payments
            int newPaymentId = insertPayment(paymentStatus, paymentMethod);

            // Updating OrderTable with the payment_id
            updateOrderPayment(newOrderId, newPaymentId);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    private int getAvailableCourierId() throws SQLException {
        String availableCourierQuery = "SELECT courier_id FROM Couriers WHERE courier_status = 'AVAILABLE'";
        try (PreparedStatement availableCourierStatement = connection.prepareStatement(availableCourierQuery)) {
            try (ResultSet availableCourierResultSet = availableCourierStatement.executeQuery()) {
                if (availableCourierResultSet.next()) {
                    return availableCourierResultSet.getInt("courier_id");
                }
            }
        }
        return 0;
    }

    private int insertOrder(String orderStatus, int userId, int courierId) throws SQLException {
        String orderInsertQuery = "INSERT INTO OrderTable (order_date, order_status, user_id, courier_id) VALUES (GETDATE(), ?, ?, ?)";
        try (PreparedStatement orderInsertStatement = connection.prepareStatement(orderInsertQuery,
                PreparedStatement.RETURN_GENERATED_KEYS)) {
            orderInsertStatement.setString(1, orderStatus);
            orderInsertStatement.setInt(2, userId);
            orderInsertStatement.setInt(3, courierId);
            orderInsertStatement.executeUpdate();

            // Retrieving the generated order_id
            try (ResultSet orderResultSet = orderInsertStatement.getGeneratedKeys()) {
                if (orderResultSet.next()) {
                    return orderResultSet.getInt(1);
                }
            }
        }
        return 0;
    }

    private void insertOrderDetails(int orderId, int productId, int quantity) throws SQLException {
        String orderDetailsInsertQuery = "INSERT INTO OrderDetails (order_id, product_id, quantity, subtotal) VALUES (?, ?, ?, 0.0)";
        try (PreparedStatement orderDetailsInsertStatement = connection.prepareStatement(orderDetailsInsertQuery)) {
            orderDetailsInsertStatement.setInt(1, orderId);
            orderDetailsInsertStatement.setInt(2, productId);
            orderDetailsInsertStatement.setInt(3, quantity);
            orderDetailsInsertStatement.executeUpdate();
        }
    }

    private int insertPayment(String paymentStatus, String paymentMethod) throws SQLException {
        String paymentInsertQuery = "INSERT INTO Payments (payment_status, payment_method) VALUES (?, ?)";
        try (PreparedStatement paymentInsertStatement = connection.prepareStatement(paymentInsertQuery,
                PreparedStatement.RETURN_GENERATED_KEYS)) {
            paymentInsertStatement.setString(1, paymentStatus);
            paymentInsertStatement.setString(2, paymentMethod);
            paymentInsertStatement.executeUpdate();

            // Retrieving the generated payment_id
            try (ResultSet paymentResultSet = paymentInsertStatement.getGeneratedKeys()) {
                if (paymentResultSet.next()) {
                    return paymentResultSet.getInt(1);
                }
            }
        }
        return 0;
    }

    private void updateOrderPayment(int orderId, int paymentId) throws SQLException {
        String updateOrderQuery = "UPDATE OrderTable SET payment_id = ? WHERE order_id = ?";
        try (PreparedStatement updateOrderStatement = connection.prepareStatement(updateOrderQuery)) {
            updateOrderStatement.setInt(1, paymentId);
            updateOrderStatement.setInt(2, orderId);
            updateOrderStatement.executeUpdate();
        }
    }

    public void closeConnection() {
        try {
            this.connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
