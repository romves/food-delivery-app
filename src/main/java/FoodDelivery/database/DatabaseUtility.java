/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FoodDelivery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Kenzie Taqiyassar
 */
public class DatabaseUtility {

    private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=FoodDeliveryApp;trustServerCertificate=true;encrypt=false";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "12345678";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
