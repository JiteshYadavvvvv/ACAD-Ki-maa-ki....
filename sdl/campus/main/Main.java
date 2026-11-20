
package campus.main;

import java.util.*;
import campus.transport.*;
import campus.vehicles.*;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Bus");
        System.out.println("2. Shuttle");
        System.out.println("3. E-Bike");
        System.out.print("Choose vehicle: ");
        int ch = sc.nextInt();

        Transport t;

        if (ch == 1)
            t = new Bus();
        else if (ch == 2)
            t = new Shuttle();
        else if (ch == 3)
            t = new EBike();
        else {
            System.out.println("Invalid choice");
            sc.close();
            return;
        }

        t.book();
        t.feature();

        sc.close();
    }
}
