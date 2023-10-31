package basdat8.models;


import lombok.Data;

@Data
public class Pelanggan {
    private int idPelanggan;
    private String nama;
    private String nomorTelepon;
    private String kodePos;
    private String kota;
    private String jalan;
}