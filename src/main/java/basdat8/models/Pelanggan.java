package basdat8.models;


import lombok.Data;

@Data
public class Pelanggan extends Person{
    private String kodePos;
    private String kota;
    private String jalan;

}