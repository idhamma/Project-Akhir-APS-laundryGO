package laundry;
public class User {
    private String username;
    private String nama;
    private String no_hp;
    private String email;
    private String alamat;

    public User(String username, String nama, String no_hp, String email, String alamat) {
        this.username = username;
        this.nama = nama;
        this.no_hp = no_hp;
        this.email = email;
        this.alamat = alamat;
    }

    public String getUsername() {
        return username;
    }
    
    public String getNama() {
        return nama;
    }

    public String getNoHp() {
        return no_hp;
    }

    public String getEmail() {
        return email;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNoHp(String no_hp) {
        this.no_hp = no_hp;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
