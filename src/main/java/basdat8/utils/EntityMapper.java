package basdat8.utils;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class EntityMapper {
    public static void mapResultSetToEntity(ResultSet resultSet, Object entity) throws SQLException {
        Class<?> entityClass = entity.getClass();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        for (int i = 1; i <= columnCount; i++) {
            String columnName = metaData.getColumnName(i);
            Field field;
            try {
                field = entityClass.getDeclaredField(columnName); // Assuming column names match field names
                field.setAccessible(true);
                field.set(entity, resultSet.getObject(i));
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
