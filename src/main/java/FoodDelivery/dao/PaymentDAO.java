/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FoodDelivery.dao;

import FoodDelivery.database.DatabaseUtility;
import FoodDelivery.models.Payment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Kenzie Taqiyassar
 */
public class PaymentDAO {
    
//    private Connection connection;
//    public PaymentDAO() {
//        try {
//            
//        } catch (Exception e) {
//        }
//    }
    
    

    public int insertPayment(String paymentStatus, String paymentMethod) {
        String INSERT_PAYMENT_QUERY = "INSERT INTO Payments (payment_status, payment_method) VALUES (?, ?)";
        try (Connection connection = DatabaseUtility.getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PAYMENT_QUERY,
                    PreparedStatement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, paymentStatus);
                preparedStatement.setString(2, paymentMethod);

                int affectedRows = preparedStatement.executeUpdate();

                if (affectedRows == 0) {
                    throw new SQLException("Creating payment failed, no rows affected.");
                }

                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int paymentId = generatedKeys.getInt(1);
                        connection.commit();
                        return paymentId;
                    } else {
                        throw new SQLException("Creating payment failed, no ID obtained.");
                    }
                }
            } catch (SQLException e) {
                connection.rollback();
                throw e;
            } finally {
                connection.setAutoCommit(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
            return -1; // Indicate failure
        }
    }

    public void updatePaymentStatus(int paymentId, String paymentStatus) {
        String UPDATE_PAYMENT_STATUS_QUERY = "UPDATE Payments SET payment_status = ? WHERE payment_id = ?";

        try (Connection connection = DatabaseUtility.getConnection()) {
            connection.setAutoCommit(false);

            try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PAYMENT_STATUS_QUERY)) {

                preparedStatement.setString(1, paymentStatus);
                preparedStatement.setInt(2, paymentId);

                preparedStatement.executeUpdate();
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                throw e;
            } finally {
                connection.setAutoCommit(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
    }

    public Payment getPaymentById(int paymentId) {
        String GET_PAYMENT_BY_ID_QUERY = "SELECT * FROM Payments WHERE payment_id = ?";
        try (Connection connection = DatabaseUtility.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(GET_PAYMENT_BY_ID_QUERY)) {

            preparedStatement.setInt(1, paymentId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Payment(
                            resultSet.getInt("payment_id"),
                            resultSet.getString("payment_status"),
                            resultSet.getString("payment_method"),
                            resultSet.getTimestamp("payment_date")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
        return null; // Payment not found
    }
}
