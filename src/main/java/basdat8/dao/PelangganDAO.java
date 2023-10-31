package basdat8.dao;

import basdat8.database.DatabaseUtility;
import basdat8.models.Pelanggan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PelangganDAO {
    private DatabaseUtility databaseUtility;

    public PelangganDAO() {
        this.databaseUtility = new DatabaseUtility();
    }

    // Create (Insert) a new Pelanggan
    public boolean createPelanggan(Pelanggan pelanggan) {
        String sql = "INSERT INTO Pelanggan (nama, nomor_telepon, kode_pos, kota, jalan) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = databaseUtility.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, pelanggan.getNama());
            statement.setString(2, pelanggan.getNomorTelepon());
            statement.setString(3, pelanggan.getKodePos());
            statement.setString(4, pelanggan.getKota());
            statement.setString(5, pelanggan.getJalan());

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Read (Retrieve) a Pelanggan by ID
    public Pelanggan getPelangganById(int id) {
        String sql = "SELECT * FROM Pelanggan WHERE id_pelanggan = ?";
        Pelanggan pelanggan = null;

        try (Connection connection = databaseUtility.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    pelanggan = new Pelanggan();
                    pelanggan.setIdPelanggan(resultSet.getInt("id_pelanggan"));
                    pelanggan.setNama(resultSet.getString("nama"));
                    pelanggan.setNomorTelepon(resultSet.getString("nomor_telepon"));
                    pelanggan.setKodePos(resultSet.getString("kode_pos"));
                    pelanggan.setKota(resultSet.getString("kota"));
                    pelanggan.setJalan(resultSet.getString("jalan"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pelanggan;
    }

    // Update an existing Pelanggan
    public boolean updatePelanggan(Pelanggan pelanggan) {
        String sql = "UPDATE Pelanggan SET nama = ?, nomor_telepon = ?, kode_pos = ?, kota = ?, jalan = ? " +
                "WHERE id_pelanggan = ?";

        try (Connection connection = databaseUtility.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, pelanggan.getNama());
            statement.setString(2, pelanggan.getNomorTelepon());
            statement.setString(3, pelanggan.getKodePos());
            statement.setString(4, pelanggan.getKota());
            statement.setString(5, pelanggan.getJalan());
            statement.setInt(6, pelanggan.getIdPelanggan());

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete a Pelanggan by ID
    public boolean deletePelanggan(int id) {
        String sql = "DELETE FROM Pelanggan WHERE id_pelanggan = ?";

        try (Connection connection = databaseUtility.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Additional methods can be added for more complex operations

    public List<Pelanggan> getAllPelanggan() {
        List<Pelanggan> pelangganList = new ArrayList<>();
        String sql = "SELECT * FROM Pelanggan";

        try (Connection connection = databaseUtility.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Pelanggan pelanggan = new Pelanggan();
                pelanggan.setIdPelanggan(resultSet.getInt("id_pelanggan"));
                pelanggan.setNama(resultSet.getString("nama"));
                pelanggan.setNomorTelepon(resultSet.getString("nomor_telepon"));
                pelanggan.setKodePos(resultSet.getString("kode_pos"));
                pelanggan.setKota(resultSet.getString("kota"));
                pelanggan.setJalan(resultSet.getString("jalan"));
                pelangganList.add(pelanggan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pelangganList;
    }
}
