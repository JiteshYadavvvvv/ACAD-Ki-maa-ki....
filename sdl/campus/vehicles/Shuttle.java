
package campus.vehicles;

import campus.transport.*;

public class Shuttle extends Vehicle {
    public Shuttle() {
        super("Shuttle");
    }

    public void feature() {
        System.out.println("Capacity: 15 students");
    }
}
