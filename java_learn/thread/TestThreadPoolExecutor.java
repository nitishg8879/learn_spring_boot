package java_learn.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThreadPoolExecutor {
    public static void main(String[] args) {
        System.out.println("Main thread: Start" + Thread.currentThread().getName());
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2, 4, 10, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(2),
                new MyCustomThreadFactory(),
                new MyCustomRejectedExecutionHandler());

        for (int i = 1; i <= 7; i++) {
            final int taskId = i;
            executor.execute(() -> {
                try {
                    Thread.sleep(5000); // Simulate work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Task processed by " + taskId + " by thread " + Thread.currentThread().getName());
            });
        }
        executor.shutdown();
        System.out.println("Main thread: End" + Thread.currentThread().getName());
    }
}

class MyCustomRejectedExecutionHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task " + r.toString() + " rejected from " + executor.toString());
    }

}

class MyCustomThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread th = new Thread(r);
        th.setPriority(5);
        th.setDaemon(false);
        return th;
    }

}
