package FoodDelivery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtility {
    private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=FoodDeliveryApp;trustServerCertificate=true;encrypt=false";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "mcddb";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
