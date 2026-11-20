
import java.util.*;

class Product {
    String name;
    double price;
    int qty;

    Product() {
        name = "Unknown";
        price = 0;
        qty = 0;
    }

    Product(String n, double p) {
        name = n;
        price = p;
        qty = 1;
    }

    Product(String n, double p, int q) {
        name = n;
        price = p;
        qty = q;
    }

    double cost() {
        return price * qty;
    }
}

class ECommerce {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        Product p[] = new Product[3];

        p[0] = new Product("Laptop", 50000, 1);
        p[1] = new Product("Mouse", 500, 2);

        System.out.print("Enter product name: ");
        String n = sc.next();

        System.out.print("Enter price: ");
        double price = sc.nextDouble();

        System.out.print("Enter quantity: ");
        int q = sc.nextInt();

        p[2] = new Product(n, price, q);

        double total = 0;

        System.out.println("\n----- INVOICE -----");

        for (Product x : p) {
            System.out.println(x.name + " " + x.price + " x " +
                    x.qty + " = " + x.cost());
            total += x.cost();
        }

        double discount = 0;

        if (total >= 50000)
            discount = total * 0.10;
        else if (total >= 20000)
            discount = total * 0.05;

        System.out.println("-------------------");
        System.out.println("Total: " + total);
        System.out.println("Discount: " + discount);
        System.out.println("Final Amount: " + (total - discount));

        sc.close();
    }
}
