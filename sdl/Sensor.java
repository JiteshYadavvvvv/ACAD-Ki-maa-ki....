
class Logger {
    static synchronized void log(String msg) {
        System.out.println(msg);
    }
}

class Sensor extends Thread {
    String name;

    Sensor(String name) {
        this.name = name;
    }

    double generateReading() {
        return 0;
    }

    boolean valid(double x) {
        return true;
    }

    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                double x = generateReading();

                if (!valid(x))
                    throw new IllegalArgumentException("Invalid reading");

                Logger.log(name + " reading: " + x);

                Thread.sleep(500);
            }
        }
        catch (IllegalArgumentException e) {
            Logger.log(name + ": " + e.getMessage());
        }
        catch (InterruptedException e) {
            Logger.log(name + " interrupted");
        }
        finally {
            Logger.log(name + " sensor terminated");
        }
    }
}

class Motion extends Sensor {
    Motion() {
        super("Motion");
    }

    double generateReading() {
        return Math.random() < 0.5 ? 0 : 1;
    }

    boolean valid(double x) {
        return x == 0 || x == 1;
    }
}

class Temperature extends Sensor {
    Temperature() {
        super("Temperature");
    }

    double generateReading() {
        return 15 + Math.random() * 25;
    }

    boolean valid(double x) {
        return x >= 0 && x <= 50;
    }
}

class CO2 extends Sensor {
    CO2() {
        super("CO2");
    }

    double generateReading() {
        if (Math.random() < 0.2)
            return 5000;
        return 400 + Math.random() * 1000;
    }

    boolean valid(double x) {
        return x >= 0 && x <= 2000;
    }
}

class Humidity extends Sensor {
    Humidity() {
        super("Humidity");
    }

    double generateReading() {
        return Math.random() * 100;
    }

    boolean valid(double x) {
        return x >= 0 && x <= 100;
    }
}

class Main {
    public static void main(String args[]) throws InterruptedException {
        Sensor s1 = new Motion();
        Sensor s2 = new Temperature();
        Sensor s3 = new CO2();
        Sensor s4 = new Humidity();

        s1.start();
        s2.start();
        s3.start();
        s4.start();

        s1.join();
        s2.join();
        s3.join();
        s4.join();

        Logger.log("Building monitoring completed");
    }
}
