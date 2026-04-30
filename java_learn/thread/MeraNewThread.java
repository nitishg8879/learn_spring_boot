package java_learn.thread;

public class MeraNewThread {
    public static void main(String[] args) {
        System.out.println("1.Main thread name: " + Thread.currentThread().getName() + " Starting");
        TestThread11 testThread11 = new TestThread11();
        Thread thread1 = new Thread(() -> {
            testThread11.take10Sec();
        });
        Thread thread2 = new Thread(() -> {
            testThread11.normalMethod();
        });
        thread1.start();
        thread2.start();
        System.out.println("5.Main thread name: " + Thread.currentThread().getName() + " Ended");
    }
}

class TestThread11 {
    
    synchronized void take10Sec() {
        System.out.println("2.Thread name: " + Thread.currentThread().getName() + " is starting with take10Sec method");
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
        }
        System.out.println("4.Thread name: " + Thread.currentThread().getName() + " is done with take10Sec method");
    }
    
    synchronized public void normalMethod() {
        System.out.println("3.Thread name: " + Thread.currentThread().getName() + " is done with normalMethod");
    }
}
