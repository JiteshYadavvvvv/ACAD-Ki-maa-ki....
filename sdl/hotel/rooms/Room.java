
package hotel.rooms;

import hotel.interfaces.*;

public class Room implements Bookable {
    String name;
    double price;
    boolean booked = false;

    public Room(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void book() {
        if (!booked) {
            booked = true;
            System.out.println(name + " booked successfully");
        }
        else
            System.out.println("Already booked");
    }

    public void cancel() {
        if (booked) {
            booked = false;
            System.out.println(name + " booking cancelled");
        }
        else
            System.out.println("Room is not booked");
    }

    public void display() {
        System.out.println("Room: " + name);
        System.out.println("Price: Rs." + price);
        System.out.println("Booked: " + booked);
    }
}
