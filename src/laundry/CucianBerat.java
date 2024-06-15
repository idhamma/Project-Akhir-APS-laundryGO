package laundry;
public class CucianBerat extends Cucian {
    private double berat;

    public CucianBerat(double harga,double berat ) {
        super(harga);
        this.berat = berat;
    }

    public double getBerat() {
        return berat;
    }
}