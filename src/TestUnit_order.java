public class TestUnit_order {
    public static void main(String[] args) {
        Penyedia_laundry penyedia = new Penyedia_laundry("1", "1234567890", "Jl. Raya No. 1", "081234567890", false);

        User user = new User("Ahmadd", "Ahmad Jeki", "081234567890", "jek@gmail.com" , "Jl. Raya No. 1");

        Pemesanan pesanan = new Pemesanan(user, penyedia);


        //admin menambahkan item ke pesanan
        Cucian cucian = new CucianBerat(10000, 5);
        Cucian cucian2 = new CucianPcs(5,"JAKET");

        Item item = new Item();
        item.add(cucian);
        item.add(cucian2);
        pesanan.addItem(item);

        pesanan.printPesanan();
    
    }
}
