package laundry;

import java.util.UUID;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Pembayaran {    
    private String idPesanan;
    private Date tanggalPemesanan;
    private Date waktuPemesanan;
    private User pelanggan;
    private Penyedia_laundry penyedia;
    private JenisLayanan jenisLayanan; 
    private boolean antarJemput;
    private JenisPembayaran jenisPembayaran;
    private Item item;
    private Date tanggalPembayaran;
    private Date waktuPembayaran;
    private double totalHarga=0;

    public Pembayaran() {
    }

    public Pembayaran(User pelanggan, Penyedia_laundry penyedia, JenisLayanan jenisLayanan, boolean antarJemput, Item item) {
        this.idPesanan = UUID.randomUUID().toString();
        this.tanggalPemesanan = new Date();
        this.waktuPemesanan = new Date();
        this.pelanggan = pelanggan;
        this.penyedia = penyedia;
        this.jenisLayanan = jenisLayanan;
        this.antarJemput = antarJemput;
        this.item = item;
        this.tanggalPembayaran = new Date();
        this.waktuPembayaran = new Date();
    }

    public Pembayaran(Pemesanan pesanan){
        this.idPesanan = pesanan.getIdPesanan();
        this.tanggalPemesanan = pesanan.getTanggalPemesanan();
        this.waktuPemesanan = pesanan.getWaktuPemesanan();
        this.pelanggan = pesanan.getPelanggan();
        this.penyedia = pesanan.getPenyedia();
        this.jenisLayanan = convertJenisLayanan(pesanan.getJenisLayanan());
        this.antarJemput = pesanan.isAntarJemput();
        this.item = pesanan.getItem();
        this.tanggalPembayaran = new Date();
        this.waktuPembayaran = new Date();
    }
    
    private JenisLayanan convertJenisLayanan(Pemesanan.JenisLayanan jenisLayanan) {
        switch (jenisLayanan) {
            case KILAT:
                return JenisLayanan.KILAT;
            case REGULER:
                return JenisLayanan.REGULER;
            case HEMAT:
                return JenisLayanan.HEMAT;
            default:
                throw new IllegalArgumentException("Invalid JenisLayanan: " + jenisLayanan);
        }
    }

    public void start(){
        Scanner input = new Scanner(System.in);
       
        System.out.println("Apakah anda ingin melanjutkan pembayaran? (Y/N)");
        String lanjut = input.next();
        if(lanjut.equals("Y") || lanjut.equals("y")){
            System.out.println("Pilih metode pembayaran: ");
            System.out.println("1. Tunai");
            System.out.println("2. Cashless");
            int metode = input.nextInt();
            if(metode == 1){
                System.out.println("Silahkan bayar dengan uang tunai, pastikan uang anda pas");
                this.jenisPembayaran = JenisPembayaran.TUNAI;
            } else if(metode == 2){
                System.out.println("Silahkan scan QRIS berikut untuk pembayaran");
                this.jenisPembayaran = JenisPembayaran.CASHLESS;
            }
            System.out.println("Pembayaran berhasil");
            System.out.println("Terima kasih telah menggunakan layanan kami");
        } else {
            System.out.println("Pembayaran dibatalkan");
        }

        
    }
    
    public void printInvoice(){
        System.out.println("ID Pesanan\t: " + this.idPesanan);
        System.out.println("Tanggal\t\t: " + formatTanggal(this.tanggalPembayaran));
        System.out.println("Waktu\t\t: " + formatWaktu(this.waktuPembayaran));
        System.out.println("Pelanggan\t: " + this.pelanggan.getNama());
        System.out.println("Lokasi laundry\t: " + this.penyedia.getAlamatLaundry());
        System.out.println("Jenis Layanan\t: " + this.jenisLayanan);
        System.out.println("Antar Jemput\t: " + this.antarJemput);
        System.out.println("Pembayaran\t: " + this.jenisPembayaran);
        this.item.printItem();
        
        System.out.println("Total item\t\t: " + item.getItem().size());
        if(this.antarJemput) {
            System.out.println("Biaya Antar Jemput\t: 7000");
        }
        System.out.println("Total Harga\t\t: " + this.totalHarga);

        System.out.println("\n\nLUNAS!!!\n\n Terima kasih telah menggunakan layanan kami");
    }

    public void addItem(Item item){
        this.item = item;
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
        this.totalHarga = totalHarga();
        System.out.println("Total Harga\t\t: " + this.totalHarga);
    }

    public enum JenisLayanan {
        KILAT,
        REGULER,
        HEMAT
    }

    public enum JenisPembayaran {
        TUNAI,
        CASHLESS
    }

    public double totalHarga() {
        double totalHarga = 0;
        totalHarga += item.getTotal();

        if(this.antarJemput) {
            totalHarga += 7000;
        }
        return totalHarga;
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
