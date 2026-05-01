package java_learn.thread;

public class ThreadLifecycleTest {
    public synchronized void task1() {
        try {
            System.out.println("Inside task:1 " + Thread.currentThread().getName());
            Thread.sleep(10000);
            System.out.println("Inside task:1 Completed" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void task2() {
        System.out.println("Inside task:2 but before synchronized block " + Thread.currentThread().getName());
        synchronized (this) {
            System.out.println("Inside task:2 synchronized block " + Thread.currentThread().getName());
        }
    }

    public void task3() {
        System.out.println("Inside task:3 " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadLifecycleTest threadLifecycleTest = new ThreadLifecycleTest();

        Thread thread1 = new Thread(() -> {
            threadLifecycleTest.task1();
        });

        Thread thread2 = new Thread(() -> {
            threadLifecycleTest.task2();
        });

        Thread thread3 = new Thread(() -> {
            threadLifecycleTest.task3();
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }

}
