/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FoodDelivery.dao;

import FoodDelivery.database.DatabaseUtility;
import FoodDelivery.models.OrderDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kenzie Taqiyassar
 */
public class ReceiptDAO {

    private Connection connection;

    public ReceiptDAO() {
        try {
            connection = DatabaseUtility.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Map<String, Object> getReceiptDataForOrderId(int orderId) {
        String selectQuery = "SELECT * FROM ReceiptView WHERE order_id = ?";

        try (
                Connection connection = DatabaseUtility.getConnection(); // Create a PreparedStatement object to execute the query
                 PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setInt(1, orderId);
            ResultSet resultSet = preparedStatement.executeQuery();
            Map<String, Object> receiptData = new HashMap<>();
            List<Map<String, Object>> itemList = new ArrayList<>();

            while (resultSet.next()) {
                receiptData.put("orderDate", resultSet.getString("order_date"));
                receiptData.put("courierName", resultSet.getString("courier_name"));
                receiptData.put("courierPlateNumber", resultSet.getString("courier_plate_number"));
                receiptData.put("orderTotal", resultSet.getDouble("order_total"));
                receiptData.put("restaurantName", resultSet.getString("restaurant_name"));
                receiptData.put("userId", resultSet.getInt("user_id"));
                receiptData.put("userName", resultSet.getString("user_name"));
                receiptData.put("userPhoneNumber", resultSet.getString("user_phone_number"));
                receiptData.put("userAddress", resultSet.getString("user_address"));
                receiptData.put("shippingCost", resultSet.getDouble("shipping_cost"));
                receiptData.put("orderId", resultSet.getInt("order_id"));
                receiptData.put("paymentMethod", resultSet.getString("payment_method"));

                Map<String, Object> itemData = new HashMap<>();
                itemData.put("quantity", resultSet.getInt("quantity"));
                itemData.put("product_name", resultSet.getString("product_name"));
                itemData.put("subtotal", resultSet.getDouble("subtotal"));
                itemList.add(itemData);
            }

            receiptData.put("items", itemList);

            return receiptData;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Map<String, Object>> getReceiptDataListForUserId(int userId) {
        String selectQuery = "SELECT * FROM ReceiptView WHERE user_id = ?";
        List<Map<String, Object>> receiptDataList = new ArrayList<>();

        try (
                Connection connection = DatabaseUtility.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {

            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Map<String, Object> receiptData = new HashMap<>();
                List<Map<String, Object>> itemList = new ArrayList<>();

                receiptData.put("orderDate", resultSet.getString("order_date"));
                receiptData.put("courierName", resultSet.getString("courier_name"));
                receiptData.put("courierPlateNumber", resultSet.getString("courier_plate_number"));
                receiptData.put("orderTotal", resultSet.getDouble("order_total"));
                receiptData.put("restaurantName", resultSet.getString("restaurant_name"));
                receiptData.put("userId", resultSet.getInt("user_id"));
                receiptData.put("userName", resultSet.getString("user_name"));
                receiptData.put("userPhoneNumber", resultSet.getString("user_phone_number"));
                receiptData.put("userAddress", resultSet.getString("user_address"));
                receiptData.put("shippingCost", resultSet.getDouble("shipping_cost"));
                receiptData.put("orderId", resultSet.getInt("order_id"));
                receiptData.put("paymentMethod", resultSet.getString("payment_method"));

                Map<String, Object> itemData = new HashMap<>();
                itemData.put("quantity", resultSet.getInt("quantity"));
                itemData.put("product_name", resultSet.getString("product_name"));
                itemData.put("subtotal", resultSet.getDouble("subtotal"));
                itemList.add(itemData);

                receiptData.put("items", itemList);
                receiptDataList.add(receiptData);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return receiptDataList;
    }

}
