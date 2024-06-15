import java.lang.reflect.Array;
import java.util.ArrayList;


public class Item {
    //item adalah array list yang berisi kumpulan cucian  
    private ArrayList<Cucian> item = new ArrayList<Cucian>();

    //method
    public void add(Cucian cucian){
        item.add(cucian);
    }

    public ArrayList<Cucian> getItem(){
        return item;
    }

    public void printItem(){
        double total = 0;
        System.out.println("Item yang dipesan: ");
        System.out.println("==========================================================");
        System.out.println("Kategori \t Quantity \t Harga \t\t Total");
        for (Cucian cucian : item) {
            if (cucian instanceof CucianBerat) {
                CucianBerat cucianBerat = (CucianBerat) cucian;
                System.out.println("PAKAIAN \t  " + cucianBerat.getBerat() + " kg" + " \t " + cucianBerat.getHarga() + " \t " + cucianBerat.getBerat()*cucianBerat.getHarga());
                total += cucianBerat.getBerat()*cucianBerat.getHarga();
            } else if (cucian instanceof CucianPcs) {
                CucianPcs cucianPcs = (CucianPcs) cucian;
                System.out.println(cucianPcs.getKategori() + " \t\t  " + cucianPcs.getJumlah() + " pcs" + " \t " + cucianPcs.getHarga() + " \t " + cucianPcs.getJumlah()*cucianPcs.getHarga());
                total += cucianPcs.getJumlah()*cucianPcs.getHarga();
            }
        }

        System.out.println("==========================================================");
        System.out.println("Total Item : " + item.size() + " item");
        System.out.println("Total Harga: Rp." + total);
    }
}
