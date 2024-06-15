import java.util.UUID;
import java.util.Date;

public class Pesanan {
    private String idPesanan;
    private Date tanggalPemesanan;
    private Date waktuPemesanan;
    private User pelanggan;
    private Penyedia_laundry penyedia;
    private JenisLayanan jenisLayanan; 
    private boolean antarJemput;
    private Item item;

    public Pesanan(User pelanggan, Penyedia_laundry penyedia, JenisLayanan jenisLayanan, boolean antarJemput, Item item) {
        this.idPesanan = UUID.randomUUID().toString();
        this.tanggalPemesanan = new Date();
        this.waktuPemesanan = new Date();
        this.pelanggan = pelanggan;
        this.penyedia = penyedia;
        this.jenisLayanan = jenisLayanan;
        this.antarJemput = antarJemput;
        this.item = item;
    }



    // public void setCucian(Cucian cucian) {
    //     this.cucian = cucian;
    // }

    // public void hitungHarga() {
    //     Harga hargaObj = new Harga();
    //     this.harga = hargaObj.hitung(this.jenisLayanan, this.cucian.getHarga(), this.antarJemput);
    // }

    public void printPesanan() {
        System.out.println("ID Pesanan\t: " + this.idPesanan);
        System.out.println("Tanggal & Waktu\t: " + this.tanggalPemesanan);
        System.out.println("Pelanggan\t: " + this.pelanggan.getNama());
        System.out.println("Lokasi laundry\t: " + this.penyedia.getAlamatLaundry());
        System.out.println("Jenis Layanan\t: " + this.jenisLayanan);
        System.out.println("Antar Jemput\t: " + this.antarJemput);
        this.item.printItem();
    }

    public enum JenisLayanan {
        REGULER,
        EXPRESS
    }

    public double totalHarga() {
        double totalHarga = 0;
        for (Cucian cucian : item.getItem()) {
            totalHarga += cucian.getHarga();
        }
        return totalHarga;
    }
}
