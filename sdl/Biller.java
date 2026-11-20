
import java.util.*;

class Biller {
    void process(String id, int units, double rate, boolean late, double paid) {
        if (!id.matches("[0-9]{6}"))
            throw new IllegalArgumentException("Invalid Consumer ID");

        if (units < 0)
            throw new IllegalArgumentException("Negative units not allowed");

        double bill = units * rate;
        if (late) bill += 50;

        System.out.println("Total Bill: Rs." + bill);

        if (paid != bill)
            throw new ArithmeticException("Incorrect payment amount");

        System.out.println("Payment successful");
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Biller b = new Biller();
        int ch = 1;

        while (ch == 1) {
            try {
                System.out.print("Consumer ID: ");
                String id = sc.next();

                System.out.print("Units consumed: ");
                int units = sc.nextInt();

                System.out.print("Rate per unit: ");
                double rate = sc.nextDouble();

                System.out.print("Late payment (true/false): ");
                boolean late = sc.nextBoolean();

                double bill = units * rate;
                if (late) bill += 50;

                System.out.println("Due Amount: Rs." + bill);
                System.out.print("Enter payment: ");
                double paid = sc.nextDouble();

                b.process(id, units, rate, late, paid);
            }
            catch (ArithmeticException | IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
            finally {
                System.out.println("Transaction logged");
            }

            System.out.print("Next customer? (1/0): ");
            ch = sc.nextInt();
        }

        sc.close();
    }
}
