
class Road implements Runnable {
    String name;

    Road(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println(name + " started");

        for (int i = 1; i <= 5; i++) {
            System.out.println("Car entering " + name);

            try {
                Thread.sleep(500);
            }
            catch (InterruptedException e) {
                System.out.println("Thread interrupted");
                return;
            }
        }

        System.out.println(name + " completed");
    }
}

class Traffic {
    public static void main(String args[]) {
        Thread t1 = new Thread(new Road("Road-A"));
        Thread t2 = new Thread(new Road("Road-B"));
        Thread t3 = new Thread(new Road("Road-C"));

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        }
        catch (InterruptedException e) {
            System.out.println("Main interrupted");
        }

        System.out.println("Traffic simulation completed");
    }
}
