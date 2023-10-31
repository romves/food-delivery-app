package basdat8.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import basdat8.database.DatabaseUtility;
import basdat8.models.Mcdonald;

public class McdonaldDAO {
    private DatabaseUtility databaseUtility;

    public McdonaldDAO() { this.databaseUtility = new DatabaseUtility(); }

    public boolean createMcdonald(Mcdonald mcdonald) {
        String sql = "INSERT INTO Mcdonald (nama_cabang)" + "VALUES (?)";

        try(Connection connection = databaseUtility.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, mcdonald.getNamaCabang());

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Mcdonald> getAllMcdonald() {
        List<Mcdonald> mcDonaldList = new ArrayList<>();
        String sql = "SELECT * FROM Mcdonald";

        try (Connection connection = databaseUtility.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Mcdonald mekdi = new Mcdonald();
                mekdi.setIdMcdonald(resultSet.getInt("id_pelanggan"));
                mekdi.setNamaCabang(resultSet.getString("nama_cabang"));
                mcDonaldList.add(mekdi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mcDonaldList;
    }

    public Mcdonald getMcdonaldById(int id) {
        String sql = "SELECT * FROM Mcdonald WHERE id_mcd = ?";
        Mcdonald mekdi = null;

        try(Connection connection = databaseUtility.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    mekdi = new Mcdonald();
                    mekdi.setIdMcdonald(resultSet.getInt("id_mcd"));
                    mekdi.setNamaCabang(resultSet.getString("nama_cabang"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mekdi;
    }
}
