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
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public List<Map<String, Object>> getOrderHistoryByUserId(int userId) {
        List<Map<String, Object>> orderHistoryList = new ArrayList<>();
        Map<Integer, Map<String, Object>> orderMap = new HashMap<>();

        try (Connection connection = DatabaseUtility.getConnection()) {
            String sql = "SELECT * FROM ReceiptView WHERE user_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, userId);

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        int orderId = resultSet.getInt("order_id");

                        // Check if the order ID is already in the map
                        Map<String, Object> orderHistory = orderMap.get(orderId);
                        if (orderHistory == null) {
                            // If not, create a new entry in the map
                            orderHistory = new HashMap<>();
                            orderHistory.put("orderId", orderId);
                            orderHistory.put("orderDate", resultSet.getString("order_date"));
                            orderHistory.put("restaurantName", resultSet.getString("restaurant_name"));
                            orderHistory.put("courierName", resultSet.getString("courier_name"));
                            orderHistory.put("courierPlateNumber", resultSet.getString("courier_plate_number"));
                            orderHistory.put("userAddress", resultSet.getString("user_address"));
                            orderHistory.put("shippingCost", resultSet.getDouble("shipping_cost"));
                            orderHistory.put("orderTotal", resultSet.getDouble("order_total"));
                            orderHistory.put("paymentMethod", resultSet.getString("payment_method"));

                            // Assuming these columns are in the ReceiptView
                            List<Map<String, Object>> itemList = new ArrayList<>();
                            orderHistory.put("items", itemList);

                            // Add the new entry to the map
                            orderMap.put(orderId, orderHistory);
                            orderHistoryList.add(orderHistory);
                        }

                        // Add item data to the existing item list
                        Map<String, Object> itemData = new HashMap<>();
                        itemData.put("quantity", resultSet.getInt("quantity"));
                        itemData.put("product_name", resultSet.getString("product_name"));
                        itemData.put("subtotal", resultSet.getDouble("subtotal"));
                        ((List<Map<String, Object>>) orderHistory.get("items")).add(itemData);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderHistoryList;
    }
}
