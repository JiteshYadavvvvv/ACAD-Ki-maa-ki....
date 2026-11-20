
import java.util.*;

interface Payment {
    void pay(double amount);
}

interface Transaction {
    void status();
}

class Card implements Payment, Transaction {
    public void pay(double amount) {
        System.out.println("Card payment: Rs." + amount);
    }

    public void status() {
        System.out.println("Card transaction successful");
    }
}

class Wallet implements Payment, Transaction {
    public void pay(double amount) {
        System.out.println("Wallet payment: Rs." + amount);
    }

    public void status() {
        System.out.println("Wallet transaction successful");
    }
}

class UPI implements Payment, Transaction {
    public void pay(double amount) {
        System.out.println("UPI payment: Rs." + amount);
    }

    public void status() {
        System.out.println("UPI transaction successful");
    }
}

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Card");
        System.out.println("2. Wallet");
        System.out.println("3. UPI");
        System.out.print("Choose payment method: ");
        int ch = sc.nextInt();

        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();

        Payment p;
        Transaction t;

        if (ch == 1) {
            p = new Card();
            t = (Card) p;
        }
        else if (ch == 2) {
            p = new Wallet();
            t = (Wallet) p;
        }
        else if (ch == 3) {
            p = new UPI();
            t = (UPI) p;
        }
        else {
            System.out.println("Invalid choice");
            sc.close();
            return;
        }

        p.pay(amount);
        t.status();

        sc.close();
    }
}
