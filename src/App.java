import java.util.Date;
import java.util.Scanner;

public class App {
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
        boolean delivery = haveDelivery.equalsIgnoreCase("yes");

        User user = new User(username, name, address, phoneNumber);

        // Membuat layanan laundry
        LaundryService laundryService = new LaundryService("LaundryGO #2", "1234567890", "Jl. Setiabudi No. 193", true, "081234567890");

        // Membuat pesanan
        Order order = new Order(user, laundryService, new Date(), 2, 10000);

        System.out.println("Pesanan berhasil dibuat untuk " + laundryService.getServiceName() + " dengan harga " + order.getPrice() + ".");

        // Melakukan pembayaran
        Payment payment = new Payment(order, order.getPrice());
        System.out.print("Apakah Anda ingin melakukan pembayaran sekarang? (yes/no): ");
        String payNow = scanner.nextLine();
        if (payNow.equalsIgnoreCase("yes")) {
            payment.makePayment();
            if (payment.isPaid()) {
                System.out.println("Pembayaran berhasil dilakukan.");
            } else {
                System.out.println("Pembayaran gagal. Pastikan pesanan telah selesai diproses.");
            }
        }

        // Menyelesaikan pesanan
        order.completeOrder();
        System.out.println("Pesanan telah selesai dicuci.");

        // Mengantar pesanan
        order.deliverOrder();
        if (order.isDelivered()) {
            System.out.println("Pesanan telah diantar ke alamat: " + user.getAddress());
        } else {
            System.out.println("Pesanan belum bisa diantar. Pastikan pesanan telah selesai dicuci.");
        }

        scanner.close();
    }
}

