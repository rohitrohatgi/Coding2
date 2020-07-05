package others;

public class TestThread {
    public static void main(String[] args) {
       Thread t1 = new Thread() {
            public void run() {
                   while (true) {
                       System.out.println("Thread 1: locked resource 1");
                       try {
                           Thread.sleep(5000);
                       } catch (Exception e) {
                       }
                   }

            }
        };

        // t2 tries to lock resource2 then resource1
        Thread t2 = new Thread() {
            public void run() {
                while (true) {
                    System.out.println("Thread 2: locked resource 2");

                    try {
                        Thread.sleep(5000);
                    } catch (Exception e) {
                    }
                }

            }
        };


        t1.start();
        t2.start();

    }
}
