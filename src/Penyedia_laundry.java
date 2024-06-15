public class Penyedia_laundry {
    private String id;
    private String no_rekening;
    private String alamat_laundry;
    private String noTelepon;
    private Boolean punya_kendaraan;

    public Penyedia_laundry(String id, String no_rekening, String alamat_laundry, String noTelepon, Boolean punya_kendaraan) {
        this.id = id;
        this.no_rekening = no_rekening;
        this.alamat_laundry = alamat_laundry;
        this.noTelepon = noTelepon;
        this.punya_kendaraan = punya_kendaraan;
    }

    public String getId() {
        return id;
    }
    
    public String getNoRekening() {
        return no_rekening;
    }

    public String getAlamatLaundry() {
        return alamat_laundry;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public Boolean getPunyaKendaraan() {
        return punya_kendaraan;
    }

    public void setNoRekening(String no_rekening) {
        this.no_rekening = no_rekening;
    }

    public void setAlamatLaundry(String alamat_laundry) {
        this.alamat_laundry = alamat_laundry;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }

    public void setPunyaKendaraan(Boolean punya_kendaraan) {
        this.punya_kendaraan = punya_kendaraan;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void tambahKendaraan() {
        this.punya_kendaraan = true;
    }

    public void hapusKendaraan() {
        this.punya_kendaraan = false;
    }

    public void tambahRekening(String no_rekening) {
        this.no_rekening = no_rekening;
    }

    public void hapusRekening() {
        this.no_rekening = null;
    }

    public void tambahAlamat(String alamat_laundry) {
        this.alamat_laundry = alamat_laundry;
    }

    public void hapusAlamat() {
        this.alamat_laundry = null;
    }

    public void tambahNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }

    public void hapusNoTelepon() {
        this.noTelepon = null;
    }

    public void tambahKendaraan(String id, String no_rekening, String alamat_laundry, String noTelepon) {
        this.id = id;
        this.no_rekening = no_rekening;
        this.alamat_laundry = alamat_laundry;
        this.noTelepon = noTelepon;
        this.punya_kendaraan = true;
    }




    
}
