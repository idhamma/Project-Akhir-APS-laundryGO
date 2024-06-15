package laundry;
import java.util.UUID;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Pemesanan {
    private String idPesanan;
    private Date tanggalPemesanan;
    private Date waktuPemesanan;
    private User pelanggan;
    private Penyedia_laundry penyedia;
    private JenisLayanan jenisLayanan; 
    private boolean antarJemput;
    private Item item;

    public Pemesanan(User pelanggan, Penyedia_laundry penyedia, JenisLayanan jenisLayanan, boolean antarJemput, Item item) {
        this.idPesanan = UUID.randomUUID().toString();
        this.tanggalPemesanan = new Date();
        this.waktuPemesanan = new Date();
        this.pelanggan = pelanggan;
        this.penyedia = penyedia;
        this.jenisLayanan = jenisLayanan;
        this.antarJemput = antarJemput;
        this.item = item;
    }

    

    public Pemesanan(User pelanggan, Penyedia_laundry penyedia){
        this.idPesanan = UUID.randomUUID().toString();
        this.tanggalPemesanan = new Date();
        this.waktuPemesanan = new Date();
        this.pelanggan = pelanggan;
        this.penyedia = penyedia;

        start();
    }

    public void addItem(Item item){
        this.item = item;
    }

    public void printPesanan() {

        System.out.println("Mohon tunggu penyedia laundry untuk mengkonfirmasi pesanan anda...\n...\n...\n");
        System.out.println("Pesanan anda telah dikonfirmasi oleh penyedia laundry, berikut ini tagihan anda:\n\n");




        System.out.println("ID Pesanan\t: " + this.idPesanan);
        System.out.println("Tanggal\t\t: " + formatTanggal(this.tanggalPemesanan));
        System.out.println("Waktu\t\t: " + formatWaktu(this.waktuPemesanan));
        System.out.println("Pelanggan\t: " + this.pelanggan.getNama());
        System.out.println("Lokasi laundry\t: " + this.penyedia.getAlamatLaundry());
        System.out.println("Jenis Layanan\t: " + this.jenisLayanan);
        System.out.println("Antar Jemput\t: " + this.antarJemput);
        this.item.printItem();
        
        System.out.println("Total item\t\t: " + item.getItem().size());
        if(this.antarJemput) {
            System.out.println("Biaya Antar Jemput\t: 7000");
        }
        System.out.println("Total Harga\t\t: " + totalHarga());
    }

    public void printBill(){
        System.out.println("Berikut ini tagihan anda:\n\n");

        System.out.println("ID Pesanan\t: " + this.idPesanan);
        System.out.println("Tanggal\t\t: " + formatTanggal(this.tanggalPemesanan));
        System.out.println("Waktu\t\t: " + formatWaktu(this.waktuPemesanan));
        System.out.println("Pelanggan\t: " + this.pelanggan.getNama());
        System.out.println("Lokasi laundry\t: " + this.penyedia.getAlamatLaundry());
        System.out.println("Jenis Layanan\t: " + this.jenisLayanan);
        System.out.println("Antar Jemput\t: " + this.antarJemput);
        this.item.printItem();
        
        System.out.println("Total item\t\t: " + item.getItem().size());
        if(this.antarJemput) {
            System.out.println("Biaya Antar Jemput\t: 7000");
        }
        System.out.println("Total Harga\t\t: " + totalHarga());
    }

    public enum JenisLayanan {
        KILAT,
        REGULER,
        HEMAT
    }

    public double totalHarga() {
        double totalHarga = 0;
        totalHarga += item.getTotal();

        if(this.antarJemput) {
            totalHarga += 7000;
        }
        return totalHarga;
    }

    public void start(){
        System.out.println("Selamat datang di LaundryGO");
        System.out.println("Silahkan pilih menu yang tersedia");
        System.out.println("1. Pesan Laundry");
        System.out.println("2. Lihat Riwayat Pesanan");
        System.out.println("3. Keluar");

        Scanner input = new Scanner(System.in);
        int pilihan = input.nextInt();

        switch (pilihan) {
            case 1:
                System.out.println("Pilih jenis layanan");
                System.out.println("1. Kilat");
                System.out.println("2. Reguler");
                System.out.println("3. Hemat");
                int jenisLayanan = input.nextInt();
                switch (jenisLayanan) {
                    case 1:
                        this.jenisLayanan = JenisLayanan.KILAT;
                        break;
                    case 2:
                        this.jenisLayanan = JenisLayanan.REGULER;
                        break;
                    case 3:
                        this.jenisLayanan = JenisLayanan.HEMAT;
                        break;
                    default:
                        System.out.println("Pilihan tidak valid");
                        break;
                }

                System.out.println("Apakah ingin antar jemput?");
                System.out.println("1. Ya");
                System.out.println("2. Tidak");
                int antarJemput = input.nextInt();
                switch (antarJemput) {
                    case 1:
                        this.antarJemput = true;
                        System.out.println(".\n.\nMohon tunggu driver untuk mengambil cucian anda, Pastikan alamat anda benar");
                        System.out.println("Alamat anda: " + pelanggan.getAlamat() + "\n.\n.\n.");
                        return;
                    case 2:
                        this.antarJemput  = false;
                        System.out.println("Silahkan datang ke lokasi laundry untuk mengantar cucian anda");
                        System.out.println("Alamat laundry: " + penyedia.getAlamatLaundry());
                        return;
                    default:
                        System.out.println("Pilihan tidak valid");
                        return;
                }

            case 2:
                System.out.println("Riwayat Pesanan");
                break;

            case 3:
                System.out.println("Terima kasih");
                break;

            default:
                System.out.println("Pilihan tidak valid");
                break;
            }
        }

    // Metode untuk memformat tanggal
    private String formatTanggal(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date);
    }

    // Metode untuk memformat waktu
    private String formatWaktu(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(date);
    }
        
    // Setter dan Getter
    public String getIdPesanan() {
        return idPesanan;
    }

    public Date getTanggalPemesanan() {
        return tanggalPemesanan;
    }

    public Date getWaktuPemesanan() {
        return waktuPemesanan;
    }

    public User getPelanggan() {
        return pelanggan;
    }

    public Penyedia_laundry getPenyedia() {
        return penyedia;
    }

    public JenisLayanan getJenisLayanan() {
        return jenisLayanan;
    }

    public boolean isAntarJemput() {
        return antarJemput;
    }

    public Item getItem() {
        return item;
    }

    public void setIdPesanan(String idPesanan) {
        this.idPesanan = idPesanan;
    }

    public void setTanggalPemesanan(Date tanggalPemesanan) {
        this.tanggalPemesanan = tanggalPemesanan;
    }

    public void setWaktuPemesanan(Date waktuPemesanan) {
        this.waktuPemesanan = waktuPemesanan;
    }

    public void setPelanggan(User pelanggan) {
        this.pelanggan = pelanggan;
    }

    public void setPenyedia(Penyedia_laundry penyedia) {
        this.penyedia = penyedia;
    }

    public void setJenisLayanan(JenisLayanan jenisLayanan) {
        this.jenisLayanan = jenisLayanan;
    }

    public void setAntarJemput(boolean antarJemput) {
        this.antarJemput = antarJemput;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
