
import java.util.*;

class Wallet {
    double balance = 1000;
    ArrayList<String> history = new ArrayList<>();

    void checkBalance() {
        System.out.println("Balance: Rs." + balance);
    }

    void addMoney(double amount) {
        if (amount < 0)
            throw new IllegalArgumentException("Negative amount not allowed");
        balance += amount;
        history.add("Added Rs." + amount);
        System.out.println("Money added successfully");
    }

    void pay(String mobile, double amount) {
        if (!mobile.matches("[0-9]{10}"))
            throw new IllegalArgumentException("Invalid mobile number");

        if (amount > balance)
            throw new ArithmeticException("Insufficient balance");

        balance -= amount;
        history.add("Paid Rs." + amount + " to " + mobile);
        System.out.println("Payment successful");
    }

    void showHistory() {
        System.out.println("Transaction History:");
        for (String x : history)
            System.out.println(x);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Wallet w = new Wallet();
        int ch = 0;

        do {
            try {
                System.out.println("\n1. Check Balance");
                System.out.println("2. Add Money");
                System.out.println("3. Pay Contact");
                System.out.println("4. Transaction History");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
                ch = sc.nextInt();

                if (ch == 1)
                    w.checkBalance();

                else if (ch == 2) {
                    System.out.print("Enter amount: ");
                    w.addMoney(sc.nextDouble());
                }

                else if (ch == 3) {
                    System.out.print("Enter mobile: ");
                    String mobile = sc.next();
                    System.out.print("Enter amount: ");
                    w.pay(mobile, sc.nextDouble());
                }

                else if (ch == 4)
                    w.showHistory();

                else if (ch == 5)
                    System.out.println("Exiting wallet");

                else
                    System.out.println("Invalid choice");
            }
            catch (ArithmeticException | IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
            finally {
                System.out.println("Session logged");
            }
        } while (ch != 5);

        sc.close();
    }
}
