

public class CucianPcs extends Cucian{
    private int jumlah;
    private String kategori;

    public CucianPcs(int jumlah,  String kategori) {
        super(5000); // default value for harga
        double harga = setHarga(KategoriType.valueOf(kategori));
        super.setHarga(harga);
        this.jumlah = jumlah;
        this.kategori = kategori;
    }

    public int getJumlah() {
        return jumlah;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public enum KategoriType {
        JAKET, 
        SPREI,
        HANDUK
    }

    public double setHarga(KategoriType kategori) {
        switch (kategori) {
            case JAKET:
                return 7000;
            case SPREI:
                return 10000;
            case HANDUK:
                return 6000;
            default:
                return 5000; // or return super.setHarga(kategori);
        }
    }
}
