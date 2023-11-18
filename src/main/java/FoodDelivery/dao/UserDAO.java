/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FoodDelivery.dao;

import FoodDelivery.database.DatabaseUtility;
import FoodDelivery.models.User;
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
public class UserDAO {

    private Connection connection;

    public UserDAO() {
        try {
            this.connection = DatabaseUtility.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately based on your application's requirements.
        }
    }

    public void closeConnection() {
        try {
            this.connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean addUser(User user) {
        String query = "INSERT INTO Users (user_name, user_email, user_address, user_phone_number, user_password) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getAddress());
            preparedStatement.setString(4, user.getPhoneNumber());
            preparedStatement.setString(5, user.getPassword());

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } 
    }

    public User getUserById(int userId) {
        String query = "SELECT * FROM Users WHERE user_id = ?";
        User user = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    user = new User(
                            resultSet.getInt("user_id"),
                            resultSet.getString("user_name"),
                            resultSet.getString("user_email"),
                            resultSet.getString("user_address"),
                            resultSet.getString("user_phone_number"),
                            resultSet.getString("user_password")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately based on your application's requirements.
        } finally {
            closeConnection();
        }

        return user;
    }

    public List<User> getAllUsers() {
        String query = "SELECT * FROM Users";
        List<User> userList = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("user_id"),
                        resultSet.getString("user_name"),
                        resultSet.getString("user_email"),
                        resultSet.getString("user_address"),
                        resultSet.getString("user_phone_number"),
                        resultSet.getString("user_password")
                );
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately based on your application's requirements.
        } finally {
            closeConnection();
        }

        return userList;
    }

    public boolean updateUser(User user) {
        String query = "UPDATE Users SET user_name = ?, user_email = ?, user_address = ?, "
                + "user_phone_number = ?, user_password = ? WHERE user_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getAddress());
            preparedStatement.setString(4, user.getPhoneNumber());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setInt(6, user.getUserId());

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately based on your application's requirements.
            return false;
        } finally {
            closeConnection();
        }
    }

    public boolean deleteUser(int userId) {
        String query = "DELETE FROM Users WHERE user_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userId);

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately based on your application's requirements.
            return false;
        } finally {
            closeConnection();
        }
    }

    public int checkPasswordByEmail(String userEmail, String password) {
        try {
            String sql = "SELECT user_password, user_id FROM Users WHERE user_email = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, userEmail);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String storedPassword = resultSet.getString("user_password");
                if (storedPassword.equals(password)) {
                    return resultSet.getInt("user_id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return -1;
    }

    public boolean isEmailUnique(String userEmail) {
        String query = "SELECT COUNT(*) AS count FROM Users WHERE user_email = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, userEmail);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt("count");
                    return count == 0; // If count is 0, email is unique; otherwise, it's not.
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return false; // Default to false in case of an exception.
    }

    public boolean isPhoneNumberUnique(String phoneNumber) {
        String query = "SELECT COUNT(*) AS count FROM Users WHERE user_phone_number = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, phoneNumber);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt("count");
                    return count == 0; // If count is 0, phone number is unique; otherwise, it's not.
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately based on your application's requirements.
        } finally {
//            closeConnection();
        }

        return false; // Default to false in case of an exception.
    }

}
