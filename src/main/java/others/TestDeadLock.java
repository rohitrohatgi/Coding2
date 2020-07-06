package others;

import java.io.IOException;
import java.io.InputStream;

public class TestDeadLock {

    public static void main(String[] args) {
        final String resource1 = "X";
        final String resource2 = "Y";
        // t1 tries to lock resource1 then resource2
        Thread t1 = new Thread() {
            public void run() {
                synchronized (resource1) {
                    System.out.println("Thread 1: locked resource 1");

                    try { Thread.sleep(100);} catch (Exception e) {}

                    synchronized (resource2) {
                        System.out.println("Thread 1: locked resource 2");
                    }
                }
            }
        };

        // t2 tries to lock resource2 then resource1
        Thread t2 = new Thread() {
            public void run() {
                synchronized (resource2) {
                    System.out.println("Thread 2: locked resource 2");

                    try { Thread.sleep(100);} catch (Exception e) {}

                    synchronized (resource1) {
                        System.out.println("Thread 2: locked resource 1");
                    }
                }
            }
        };
        Thread t3 = new Thread(){
            private InputStream in =  System.in;
            //public IOBlocked(InputStream is) { in = is; }
            public void run() {
                try {
                    System.out.println("Waiting for read():");
                    in.read();
                } catch(IOException e) {
                    if(Thread.currentThread().isInterrupted()) {
                        System.out.println("Interrupted from blocked I/O");
                    } else {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Exiting IOBlocked.run()");
            }
        };


      //  t1.start();
      //  t2.start();
        System.out.println(25%26);
        t3.start();
    }

}
