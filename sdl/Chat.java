
class ChatUser implements Runnable {
    String name;
    boolean paused = false, stopped = false;

    ChatUser(String name) {
        this.name = name;
    }

    synchronized void suspendChat() {
        paused = true;
    }

    synchronized void resumeChat() {
        paused = false;
        notify();
    }

    synchronized void stopChat() {
        stopped = true;
        paused = false;
        notify();
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            synchronized (this) {
                while (paused && !stopped) {
                    try {
                        wait();
                    }
                    catch (InterruptedException e) {
                        return;
                    }
                }

                if (stopped)
                    break;
            }

            System.out.println(name + " sends message " + i);

            try {
                Thread.sleep(500);
            }
            catch (InterruptedException e) {
                break;
            }
        }

        System.out.println(name + " chat ended");
    }
}

class Chat {
    public static void main(String args[]) throws InterruptedException {
        ChatUser u1 = new ChatUser("User-1");
        ChatUser u2 = new ChatUser("User-2");

        Thread t1 = new Thread(u1);
        Thread t2 = new Thread(u2);

        t1.setPriority(10);
        t2.setPriority(1);

        t1.start();
        t2.start();

        System.out.println("User-1 alive: " + t1.isAlive());
        System.out.println("User-2 alive: " + t2.isAlive());

        Thread.sleep(1000);
        u2.suspendChat();
        System.out.println("User-2 suspended");

        Thread.sleep(1000);
        u2.resumeChat();
        System.out.println("User-2 resumed");

        Thread.sleep(1000);
        u1.stopChat();
        System.out.println("User-1 stopped");

        t1.join();
        t2.join();

        System.out.println("Chat system completed");
    }
}
