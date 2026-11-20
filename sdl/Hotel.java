
import java.util.*;

class Hotel {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int room[][] = new int[3][4];
        int ch, f, r;

        do {
            System.out.println("\n1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            ch = sc.nextInt();

            if (ch == 1) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 4; j++)
                        System.out.print(room[i][j] == 0 ? "Available " : "Booked ");
                    System.out.println();
                }
            }

            else if (ch == 2) {
                System.out.print("Enter floor (1-3): ");
                f = sc.nextInt();
                System.out.print("Enter room (1-4): ");
                r = sc.nextInt();

                if (f < 1 || f > 3 || r < 1 || r > 4)
                    System.out.println("Invalid room!");
                else if (room[f-1][r-1] == 0) {
                    room[f-1][r-1] = 1;
                    System.out.println("Room booked!");
                }
                else
                    System.out.println("Already booked!");
            }

            else if (ch == 3)
                System.out.println("Thank you!");

            else
                System.out.println("Invalid choice!");

        } while (ch != 3);

        sc.close();
    }
}
