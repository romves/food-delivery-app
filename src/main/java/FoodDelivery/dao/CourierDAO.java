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
                        resultSet.getString("delivery_status"),
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
        String sql = "UPDATE Couriers SET delivery_status = ?, courier_name = ?, courier_phone_number = ?, courier_plate_number = ? WHERE courier_id = ?";
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
}
