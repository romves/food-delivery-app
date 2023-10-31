package basdat8.database;

import java.sql.*;

public class DatabaseUtility {
    private Connection connection;

    public DatabaseUtility() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=FoodDeliveryDB;user=sa;password=Y2FwdGFpbnNpbGVuY2VzbGlwbWU=;encrypt=false;");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void testConnection() {
        try {
            Connection connection1 = this.getConnection();
            if (connection1 != null && !connection1.isClosed()) {
                System.out.println("Database connection is successful.");
            } else {
                System.out.println("Database connection is not established.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.close();
    }

    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String sql) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sql);
        return statement.executeQuery();
    }

    public int executeUpdate(String sql) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sql);
        return statement.executeUpdate();
    }
}
