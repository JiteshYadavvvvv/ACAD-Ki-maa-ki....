
package campus.transport;

public abstract class Vehicle implements Transport {
    String name;

    public Vehicle(String name) {
        this.name = name;
    }

    public void book() {
        System.out.println(name + " booked successfully");
    }
}
