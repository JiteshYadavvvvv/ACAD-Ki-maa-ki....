
package ems.app;

import java.util.*;
import ems.model.*;
import ems.services.*;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter employee name: ");
        String name = sc.next();

        System.out.print("Enter salary: ");
        double salary = sc.nextDouble();

        System.out.println("1. Full Time");
        System.out.println("2. Part Time");
        System.out.print("Choose employee type: ");
        int ch = sc.nextInt();

        Employee e;
        TaxCalculable t;

        if (ch == 1) {
            e = new FullTimeEmployee(name, salary);
            t = (TaxCalculable) e;
        }
        else if (ch == 2) {
            e = new PartTimeEmployee(name, salary);
            t = (TaxCalculable) e;
        }
        else {
            System.out.println("Invalid choice");
            sc.close();
            return;
        }

        e.display();
        double tax = t.calculateTax();

        System.out.println("Tax: " + tax);
        System.out.println("Net Salary: " + (salary - tax));

        sc.close();
    }
}
