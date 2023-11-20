/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FoodDelivery.dao;

import FoodDelivery.database.DatabaseUtility;
import FoodDelivery.models.Payment;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 *
 * @author Kenzie Taqiyassar
 */
public class PaymentDAO {

    private Connection connection;

    public PaymentDAO() {
        try {
            connection = DatabaseUtility.getConnection();
        } catch (Exception e) {
        }
    }

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

    public int createOrderFromPayment(
            String paymentStatus,
            String paymentMethod,
            int restaurantId,
            int userId
    ) {
        String procedureCall = "{call CreateOrderFromPayment(?, ?, ?, ?, ?)}";
        int paymentId = -1; // Default value in case of an error

        try (CallableStatement callableStatement = connection.prepareCall(procedureCall)) {
            callableStatement.registerOutParameter(1, Types.INTEGER); // Output parameter for payment_id
            callableStatement.setString(2, paymentStatus);
            callableStatement.setString(3, paymentMethod);
            callableStatement.setInt(4, restaurantId);
            callableStatement.setInt(5, userId);

            callableStatement.execute();

            // Retrieve the generated payment_id
            paymentId = callableStatement.getInt(1);
            System.out.println("Order created successfully with payment_id: " + paymentId);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or log the error if necessary
        } finally {
            // Perform any cleanup or resource release if needed
        }

        return paymentId;
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

    public void updatePaymentMethod(int paymentId, String newPaymentMethod) {
        String UPDATE_PAYMENT_METHOD_QUERY = "UPDATE Payments SET payment_method = ? WHERE payment_id = ?";

        try (Connection connection = DatabaseUtility.getConnection()) {
            connection.setAutoCommit(false);

            try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PAYMENT_METHOD_QUERY)) {
                preparedStatement.setString(1, newPaymentMethod);
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

    public void deletePaymentById(int paymentId) {
        String DELETE_PAYMENT_QUERY = "DELETE FROM Payments WHERE payment_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PAYMENT_QUERY)) {
            preparedStatement.setInt(1, paymentId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            resetPaymentIdentity();
        }
    }

    public void resetPaymentIdentity() {
        String RESET_IDENTITY_QUERY = "DBCC CHECKIDENT('Payments', RESEED)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(RESET_IDENTITY_QUERY)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
//            closeConnection();
        }
    }

}
