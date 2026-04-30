package java_learn.thread;

public class SharedResourceTest {
    private boolean isItemAvailable = false;

    public synchronized void addItem() {
        isItemAvailable = true;
        System.out.println("Item added by " + Thread.currentThread().getName()
                + " and invoking all threads waiting for item to be available");
        notifyAll();
    }
    public synchronized void consumeItem() {
        System.out.println("Consume method invoke by: " + Thread.currentThread().getName());
        while (!isItemAvailable) {
            try {
                System.out.println("Thread " + Thread.currentThread().getName() + " is waiting now");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isItemAvailable = false;
        System.out.println("Item consumed by " + Thread.currentThread().getName());
    }
}

class ProduceTask implements Runnable {
    private SharedResourceTest sharedResourceTest;

    ProduceTask(SharedResourceTest sharedResourceTest) {
        this.sharedResourceTest = sharedResourceTest;
    }

    @Override
    public void run() {
        System.out.println("Producer thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000l);// 5seconds
        } catch (Exception e) {
            e.printStackTrace();
        }
        sharedResourceTest.addItem();
    }
}

class ConsumeTest implements Runnable {
    private SharedResourceTest sharedResourceTest;

    ConsumeTest(SharedResourceTest sharedResourceTest) {
        this.sharedResourceTest = sharedResourceTest;
    }

    @Override
    public void run() {
        System.out.println("Consumer thread: " + Thread.currentThread().getName());
        sharedResourceTest.consumeItem();
    }
}

class MainTest {
    public static void main(String[] args) {
        System.out.println("Main thread Start: " + Thread.currentThread().getName());
        SharedResourceTest sharedResourceTest = new SharedResourceTest();
        // ? prodcer thread
        Thread producerThread = new Thread(new ProduceTask(sharedResourceTest));
        // ? consumer thread
        Thread consumerThread1 = new Thread(new ConsumeTest(sharedResourceTest));

        producerThread.start();
        consumerThread1.start();

        System.out.println("Main thread End: " + Thread.currentThread().getName());
    }
}