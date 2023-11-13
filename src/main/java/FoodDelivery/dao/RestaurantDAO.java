/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FoodDelivery.dao;

import FoodDelivery.database.DatabaseUtility;
import FoodDelivery.models.Restaurant;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author UsEr
 */
public class RestaurantDAO {

    private Connection connection;

    // Constructor to initialize the connection
    public RestaurantDAO() {
        try {
            this.connection = DatabaseUtility.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addRestaurant(Restaurant restaurant) {
        String query = "INSERT INTO Restaurant (restaurant_name, restaurant_email, restaurant_password, restaurant_address, restaurant_description, restaurant_phone_number, restaurant_balance) VALUES (?, ?, ?, ?, ?, ?, 0.0)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, restaurant.getName());
            preparedStatement.setString(2, restaurant.getEmail());
            preparedStatement.setString(3, restaurant.getPassword());
            preparedStatement.setString(4, restaurant.getAddress());
            preparedStatement.setString(5, restaurant.getDescription());
            preparedStatement.setString(6, restaurant.getPhoneNumber());

            preparedStatement.executeUpdate();

            // Retrieve the generated restaurant_id
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int restaurantId = generatedKeys.getInt(1);
                restaurant.setId(restaurantId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> restaurants = new ArrayList<>();
        String query = "SELECT * FROM Restaurant";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Restaurant restaurant = new Restaurant();
                restaurant.setId(resultSet.getInt("restaurant_id"));
                restaurant.setName(resultSet.getString("restaurant_name"));
                restaurant.setEmail(resultSet.getString("restaurant_email"));
                restaurant.setPassword(resultSet.getString("restaurant_password"));
                restaurant.setAddress(resultSet.getString("restaurant_address"));
                restaurant.setDescription(resultSet.getString("restaurant_description"));
                restaurant.setPhoneNumber(resultSet.getString("restaurant_phone_number"));
                restaurant.setBalance(resultSet.getBigDecimal("restaurant_balance"));
                restaurants.add(restaurant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return restaurants;
    }

    public void updateRestaurant(Restaurant restaurant) {
        String query = "UPDATE Restaurant SET restaurant_name=?, restaurant_email=?, restaurant_password=?, restaurant_address=?, restaurant_description=?, restaurant_phone_number=? WHERE restaurant_id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, restaurant.getName());
            preparedStatement.setString(2, restaurant.getEmail());
            preparedStatement.setString(3, restaurant.getPassword());
            preparedStatement.setString(4, restaurant.getAddress());
            preparedStatement.setString(5, restaurant.getDescription());
            preparedStatement.setString(6, restaurant.getPhoneNumber());
            preparedStatement.setInt(7, restaurant.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a restaurant from the database
    public void deleteRestaurant(int restaurantId) {
        String query = "DELETE FROM Restaurant WHERE restaurant_id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, restaurantId);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
