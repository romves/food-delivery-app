package basdat8;

import basdat8.dao.PelangganDAO;
import basdat8.database.DatabaseUtility;
import basdat8.models.Pelanggan;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DatabaseUtility dbUtils = new DatabaseUtility();

        dbUtils.testConnection();

        PelangganDAO pelangganDAO = new PelangganDAO();

//        Pelanggan pelanggan1 = new Pelanggan();
//        pelanggan1.setNama("Naufal R");
//        pelanggan1.setNomorTelepon("0812345678");
//        pelanggan1.setKota("Malang");
//        pelanggan1.setJalan("Jl. Panjaitan");
//        pelanggan1.setKodePos("65122");
//
//        boolean success = pelangganDAO.createPelanggan(pelanggan1);
//
//        if(success) {
//            System.out.println("Create Success");
//        } else {
//            System.out.println("Fail to Create");
//        }

//        List<Pelanggan> pelanggans = pelangganDAO.getAllPelanggan();
//
//        for (Pelanggan x : pelanggans) {
//            System.out.println(x.toString());
//        }

//        Pelanggan pelanggan = pelangganDAO.getPelangganById(1);
//        System.out.println(pelanggan.toString());
    }
}
