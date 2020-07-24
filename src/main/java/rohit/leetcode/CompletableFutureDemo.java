package rohit.leetcode;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureDemo {
    private static final CompletableFuture<String> COMPLETABLE_FUTURE = new CompletableFuture<>();;

    public void performAsync() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
    }
    public static void main(String[] args) {
        CompletableFutureDemo cfd = new CompletableFutureDemo();
        try {
            cfd.performAsync();
                System.out.println("get()->   " + COMPLETABLE_FUTURE.get());
            System.out.println("isDone  " + COMPLETABLE_FUTURE.isDone());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }  catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
