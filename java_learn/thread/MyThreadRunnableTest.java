package java_learn.thread;

public class MyThreadRunnableTest {
    public static void main(String[] args) {
        System.out.println("Main Thread name: " + Thread.currentThread().getName());
        MyThreadRunnableTestImpl myThreadRunnableTestImpl = new MyThreadRunnableTestImpl();
        myThreadRunnableTestImpl.run(); // This will run in the main thread, not a new thread

        Thread thread = new Thread(myThreadRunnableTestImpl);
        thread.start(); // This will run in a new thread
        System.out.println("New Thread name: " + thread.getName());
    }
}




class MyThreadRunnableTestImpl implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            System.out.println("MyThreadRunnableTest: " + i);
            try {
                Thread.sleep(800); // Sleep for 0.8 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("MyThreadRunnableTest name: " + Thread.currentThread().getName());
    }
}