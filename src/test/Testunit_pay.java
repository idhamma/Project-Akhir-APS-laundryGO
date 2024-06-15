package test;

import laundry.Cucian;
import laundry.CucianBerat;
import laundry.CucianPcs;
import laundry.Item;
import laundry.Pemesanan;
import laundry.Pembayaran;
import laundry.Penyedia_laundry;
import laundry.User;

public class Testunit_pay {
    public static void main(String[] args) {

        //menggunakan order yang sudah dibuat
        Penyedia_laundry penyedia = new Penyedia_laundry("1", "1234567890", "Jl. Veteran No. 13, Malang Raya", "081234567890", true);

        User user = new User("Ahmadd", "Ahmad Jeki", "081234567890", "jek@gmail.com" , "Jl. Sigura-gura No. 33 Malang");

        //admin menambahkan item ke pesanan
        Cucian cucian = new CucianBerat(10000, 5);
        Cucian cucian2 = new CucianPcs(5,"JAKET");
        
        Item item = new Item();
        item.add(cucian);
        item.add(cucian2);

        // Pemesanan pesanan = new Pemesanan(user, penyedia, REGULER, true, item);
        Pemesanan pesanan = new Pemesanan(user, penyedia, Pemesanan.JenisLayanan.REGULER, true, item);
        Pembayaran pembayaran = new Pembayaran(pesanan);

        pembayaran.printBill();

        pembayaran.start();

        pembayaran.printInvoice();

    }
}
