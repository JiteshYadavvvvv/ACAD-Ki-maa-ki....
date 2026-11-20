
import java.util.*;

class ATM {
    double balance = 5000;

    void checkBalance() {
        System.out.println("Balance: Rs." + balance);
    }

    void deposit(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Invalid deposit amount");
        balance += amount;
        System.out.println("Money deposited successfully");
    }

    void withdraw(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Invalid withdrawal amount");
        if (amount > balance)
            throw new ArithmeticException("Insufficient funds");
        balance -= amount;
        System.out.println("Money withdrawn successfully");
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        ATM a = new ATM();
        int ch = 0;

        do {
            try {
                System.out.println("\n1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Enter choice: ");
                ch = sc.nextInt();

                if (ch == 1)
                    a.checkBalance();

                else if (ch == 2) {
                    System.out.print("Enter amount: ");
                    a.deposit(sc.nextDouble());
                }

                else if (ch == 3) {
                    System.out.print("Enter amount: ");
                    a.withdraw(sc.nextDouble());
                }

                else if (ch == 4)
                    System.out.println("Thank you!");

                else
                    throw new IllegalArgumentException("Invalid choice");
            }
            catch (ArithmeticException | IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
            finally {
                System.out.println("Transaction completed");
            }
        } while (ch != 4);

        sc.close();
    }
}
