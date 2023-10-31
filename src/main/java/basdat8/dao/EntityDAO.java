package basdat8.dao;

import basdat8.database.DatabaseUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EntityDAO<T> {
    private final DatabaseUtility databaseUtility;
    private final String tableName;
    private final String idColumnName;

    public EntityDAO(String tableName, String idColumnName) {
        this.databaseUtility = new DatabaseUtility();
        this.tableName = tableName;
        this.idColumnName = idColumnName;
    }

    public boolean createEntity(T entity, String insertSql) {
        try (Connection connection = databaseUtility.getConnection();
             PreparedStatement statement = connection.prepareStatement(insertSql)) {

            // Set parameters for the PreparedStatement based on entity-specific properties

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public T getEntityById(int id, String selectSql, IEntityFactory<T> entityFactory) {
        try (Connection connection = databaseUtility.getConnection();
             PreparedStatement statement = connection.prepareStatement(selectSql)) {

            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return entityFactory.createEntity(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean updateEntity(T entity, String updateSql) {
        try (Connection connection = databaseUtility.getConnection();
             PreparedStatement statement = connection.prepareStatement(updateSql)) {

            // Set parameters for the PreparedStatement based on entity-specific properties

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteEntity(int id, String deleteSql) {
        try (Connection connection = databaseUtility.getConnection();
             PreparedStatement statement = connection.prepareStatement(deleteSql)) {

            statement.setInt(1, id);

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<T> getAllEntities(String selectAllSql, IEntityFactory<T> entityFactory) {
        List<T> entityList = new ArrayList<>();

        try (Connection connection = databaseUtility.getConnection();
             PreparedStatement statement = connection.prepareStatement(selectAllSql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                T entity = entityFactory.createEntity(resultSet);
                entityList.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entityList;
    }
}

interface IEntityFactory<T> {
    T createEntity(ResultSet resultSet) throws SQLException;
}

