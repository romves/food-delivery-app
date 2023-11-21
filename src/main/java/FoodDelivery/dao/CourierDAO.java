/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FoodDelivery.dao;

/**
 *
 * @author Kenzie Taqiyassar
 */
import FoodDelivery.database.DatabaseUtility;
import FoodDelivery.models.Courier;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CourierDAO {

    private Connection connection;

    public CourierDAO() {
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

    public void addCourier(Courier courier) {
        String query = "INSERT INTO Couriers (delivery_status, courier_name, courier_phone_number, courier_plate_number) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, courier.getDeliveryStatus());
            preparedStatement.setString(2, courier.getName());
            preparedStatement.setString(3, courier.getPhoneNumber());
            preparedStatement.setString(4, courier.getPlateNumber());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                // Jika ada baris yang terpengaruh, dapatkan nilai ID yang dihasilkan oleh database
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int generatedId = generatedKeys.getInt(1);
                        courier.setCourierId(generatedId);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    // Mendapatkan semua kurir dari basis data
    public List<Courier> getAllCouriers() {
        List<Courier> couriers = new ArrayList<>();
        String query = "SELECT * FROM Couriers";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Courier courier = new Courier(
                        resultSet.getInt("courier_id"),
                        resultSet.getString("courier_status"),
                        resultSet.getString("courier_name"),
                        resultSet.getString("courier_phone_number"),
                        resultSet.getString("courier_plate_number")
                );
                couriers.add(courier);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return couriers;
    }

    // Mengupdate status pengiriman seorang kurir berdasarkan ID
    public void updateDeliveryStatus(String courierId, String newStatus) {
        String query = "UPDATE Couriers SET delivery_status = ? WHERE courier_id = ?";
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

    public void updateCourier(Courier courier) {
        String sql = "UPDATE Couriers SET courier_status = ?, courier_name = ?, courier_phone_number = ?, courier_plate_number = ? WHERE courier_id = ?";
        try (Connection connection = DatabaseUtility.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, courier.getDeliveryStatus());
            preparedStatement.setString(2, courier.getName());
            preparedStatement.setString(3, courier.getPhoneNumber());
            preparedStatement.setString(4, courier.getPlateNumber());
            preparedStatement.setInt(5, courier.getCourierId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    // Delete
    public void deleteCourier(int courierId) {
        String sql = "DELETE FROM Couriers WHERE courier_id = ?";
        try (Connection connection = DatabaseUtility.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, courierId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

//    public void assignCourierToOrder(int orderId) {
//        String storedProcedureCall = "{CALL AssignCourierToOrder(?, ?)}";
//        try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
//            callableStatement.setInt(1, orderId);
//            callableStatement.registerOutParameter(2, java.sql.Types.INTEGER); // Output parameter for CourierID
//            callableStatement.execute();
//            int courierId = callableStatement.getInt(2);
//            if (courierId > 0) {
//                System.out.println("Courier assigned successfully. Courier ID: " + courierId);
//            } else {
//                System.out.println("Failed to assign courier. All couriers are busy.");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            closeConnection();
//        }
//    }
    public int assignCourierToOrder(int orderId) {
        String storedProcedureCall = "{CALL AssignCourierToOrder(?, ?)}";
        int courierId = 0;
        try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
            // Set parameter values
            callableStatement.setInt(1, orderId);
            callableStatement.registerOutParameter(2, java.sql.Types.INTEGER); // Output parameter for CourierID

            // Execute the stored procedure
            callableStatement.execute();

            // Retrieve the output parameter value (CourierID)
            courierId = callableStatement.getInt(2);

            if (courierId > 0) {
                System.out.println("Courier assigned successfully. Courier ID: " + courierId);
            } else {
                System.out.println("Failed to assign courier. All couriers are busy.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return courierId;
    }

    public Courier getCourierByOrderID(int orderId) {
        Courier courier = null;
        String query = "SELECT c.* FROM Couriers c "
                + "JOIN OrderTable o ON c.courier_id = o.courier_id "
                + "WHERE o.order_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, orderId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    courier = new Courier(
                            resultSet.getInt("courier_id"),
                            resultSet.getString("courier_status"),
                            resultSet.getString("courier_name"),
                            resultSet.getString("courier_phone_number"),
                            resultSet.getString("courier_plate_number")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return courier;
    }

    public void updateCourierStatusDelivered(int orderId) {
        String query = "UPDATE Couriers SET courier_status = 'AVAILABLE' "
                + "WHERE courier_id = (SELECT courier_id FROM OrderTable WHERE order_id = ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, orderId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
}
