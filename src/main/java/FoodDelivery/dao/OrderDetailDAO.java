/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FoodDelivery.dao;

import FoodDelivery.database.DatabaseUtility;
import FoodDelivery.models.OrderDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Kenzie Taqiyassar
 */
public class OrderDetailDAO {

    private Connection connection;

    public OrderDetailDAO() {
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

    public void addOrderDetail(OrderDetail orderDetail) {
        String query = "INSERT INTO OrderDetails (order_id, product_id, quantity) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, orderDetail.getOrderId());
            preparedStatement.setInt(2, orderDetail.getProductId());
            preparedStatement.setInt(3, orderDetail.getQuantity());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

}
