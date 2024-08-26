import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter cliente data:");

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.next()) ;

        Client client = new Client(name, email, birthDate);


        System.out.println("Enter order data: ");

        System.out.print("Status: ");
        sc.nextLine();
        String status = sc.nextLine();


        Order order = new Order(new Date(), OrderStatus.valueOf(status), client);

        System.out.print("How man items to this order? ");
        int nItems = sc.nextInt();

        for(int i = 1; i <= nItems; i++){
            System.out.println("Enter #" + i +" item data:");

            System.out.print("Product name: ");
            sc.nextLine();
            String nameProduct = sc.nextLine();

            System.out.print("Product price: ");
            double priceProduct = sc.nextDouble();

            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            Product product = new Product(nameProduct, priceProduct);
            OrderItem orderItem = new OrderItem(product, quantity, priceProduct);

            order.addOrderItem(orderItem);
        }

        System.out.println(order);




        sc.close();

    }
}