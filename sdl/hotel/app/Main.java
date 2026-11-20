
package hotel.app;

import java.util.*;
import hotel.rooms.*;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Deluxe Room");
        System.out.println("2. Suite Room");
        System.out.println("3. Standard Room");
        System.out.print("Choose room: ");
        int ch = sc.nextInt();

        Room r;

        if (ch == 1)
            r = new DeluxeRoom();
        else if (ch == 2)
            r = new SuiteRoom();
        else if (ch == 3)
            r = new StandardRoom();
        else {
            System.out.println("Invalid choice");
            sc.close();
            return;
        }

        System.out.println("1. Book");
        System.out.println("2. Cancel");
        System.out.println("3. View Details");
        System.out.print("Enter choice: ");
        int op = sc.nextInt();

        if (op == 1)
            r.book();
        else if (op == 2)
            r.cancel();
        else if (op == 3)
            r.display();
        else
            System.out.println("Invalid choice");

        sc.close();
    }
}
