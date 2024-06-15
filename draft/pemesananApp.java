import java.util.Date;
import java.util.Scanner;



public class pemesananApp {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        // Membuat user
        System.out.print("Masukkan nama Anda: ");
        String name = scanner.nextLine();
        String username = name.toLowerCase().replace(" ", "_");
        System.out.print("Masukkan alamat Anda: ");
        String address = scanner.nextLine();
        System.out.print("Masukkan nomor telepon Anda: ");
        String phoneNumber = scanner.nextLine();

        System.out.println("Apakah anda ingin menggunakan layanan antar jemput? (yes/no): ");
        String haveDelivery = scanner.nextLine();
        
        User user = new User(username, name, address, phoneNumber);
        
        // Membuat layanan laundry
        LaundryService laundryService = new LaundryService("LaundryGO #2", "1234567890", "Jl. Setiabudi No. 193", false, "081234567890");
        laundryService.setHaveDelivery(haveDelivery.equalsIgnoreCase("yes"));

        // Membuat pesanan

        System.out.print("Berat pakaian: ");
        double weight = scanner.nextDouble();
        Order order = new Order(user, laundryService, new Date(), weight);

        System.out.println("Pesanan berhasil dibuat untuk " + laundryService.getServiceName() + " dengan harga " + order.getPrice() + ".");

    }
}

