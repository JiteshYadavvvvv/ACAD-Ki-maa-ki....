
import java.util.*;

class Temperature {

    static double average(double a[]) {
        double sum = 0;
        for (double x : a)
            sum += x;
        return sum / a.length;
    }

    static double max(double a[]) {
        double m = a[0];
        for (double x : a)
            if (x > m) m = x;
        return m;
    }

    static double min(double a[]) {
        double m = a[0];
        for (double x : a)
            if (x < m) m = x;
        return m;
    }

    static int aboveAverage(double a[]) {
        int count = 0;
        double avg = average(a);

        for (double x : a)
            if (x > avg) count++;

        return count;
    }

    static double total(double... a) {
        double sum = 0;
        for (double x : a)
            sum += x;
        return sum;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of days: ");
        int n = sc.nextInt();

        double temp[] = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter temperature: ");
            temp[i] = sc.nextDouble();
        }

        System.out.println("Average: " + average(temp));
        System.out.println("Maximum: " + max(temp));
        System.out.println("Minimum: " + min(temp));
        System.out.println("Above Average Days: " + aboveAverage(temp));
        System.out.println("Total Temperature: " + total(temp));

        sc.close();
    }
}
