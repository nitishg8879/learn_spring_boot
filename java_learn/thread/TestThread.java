package java_learn.thread;

public class TestThread {
    public static void main(String[] args) {
        System.out.println("Main Thread name: " + Thread.currentThread().getName());
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                System.out.println("Thread 1: " + i);
                try {
                    Thread.sleep(1000); // Sleep for 1 second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Thread 1 name: " + Thread.currentThread().getName());
        });
        

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                System.out.println("Thread 2: " + i);
                try {
                    Thread.sleep(1500); // Sleep for 1.5 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Thread 2 name: " + Thread.currentThread().getName());
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join(); // Wait for thread1 to finish
            thread2.join(); // Wait for thread2 to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Both threads have finished execution.");
    }
}
