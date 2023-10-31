package basdat8.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import basdat8.database.DatabaseUtility;
import basdat8.models.Mcdonald;
import basdat8.models.Pegawai;

public class PegawaiDAO{
    private DatabaseUtility databaseUtility;

    public PegawaiDAO() {
        this.databaseUtility = new DatabaseUtility();
    }

    public boolean createPegawai(Pegawai pegawai, Mcdonald mcdonald) {
        String sql = "INSERT INTO Pegawai (nama, nomor_telepon, id_mcd)" + "VALUES (?, ?, ?)";

        try (Connection connection = databaseUtility.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, pegawai.getNama());
            statement.setString(2, pegawai.getNomorTelepon());
            statement.setInt(3, mcdonald.getIdMcdonald());

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Pegawai getPegawaiById(int id) {
        String sql = "SELECT * FROM Pegawai WHERE id_pegawai = ?";
        Pegawai pegawai = null;

        try(Connection connection = databaseUtility.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            try(ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    pegawai = new Pegawai();
                    pegawai.setId(resultSet.getInt("id_pegawai"));
                    pegawai.setNama(resultSet.getString("nama"));
                    pegawai.setNomorTelepon(resultSet.getString("nomor_telepon"));
                    pegawai.setId(resultSet.getInt("id_mcd"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new Pegawai();
    }


}
