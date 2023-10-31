package basdat8.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import basdat8.database.DatabaseUtility;
import basdat8.models.Kurir;

public class KurirDAO {
    private DatabaseUtility databaseUtility;

    public KurirDAO() {
        this.databaseUtility = new DatabaseUtility();
    }

    public boolean createKurir(Kurir kurir) {
        String sql = "INSERT INTO Pelanggan (nama, plat_nomor, nomor_telepon)" +
                "VALUES (?, ?, ?)";

        try (Connection connection = databaseUtility.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, kurir.getNama());
            statement.setString(2, kurir.getPlatNomor());
            statement.setString(3, kurir.getNomorTelepon());

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Kurir getKurirById(int id) {
        String sql = "SELECT * FROM Kurir WHERE id_kurir = ?";
        Kurir kurir = null;

        try (Connection connection = databaseUtility.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    kurir = new Kurir();
                    kurir.setId(resultSet.getInt("id_kurir"));
                    kurir.setNama(resultSet.getString("nama"));
                    kurir.setPlatNomor(resultSet.getString("plat_nomor"));
                    kurir.setNomorTelepon(resultSet.getString("nomor_telepon"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kurir;
    }

    public List<Kurir> getAllKurir() {
        List<Kurir> kurirList = new ArrayList<>();
        String sql = "SELECT * FROM Kurir";

        try (Connection connection = databaseUtility.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Kurir kurir = new Kurir();
                kurir.setId(resultSet.getInt("id_kurir"));
                kurir.setNama(resultSet.getString("nama"));
                kurir.setPlatNomor(resultSet.getString("plat_nomor"));
                kurir.setNomorTelepon(resultSet.getString("nomor_telepon"));
                kurirList.add(kurir);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kurirList;
    }
}
