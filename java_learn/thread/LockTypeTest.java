package java_learn.thread;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class LockTypeTestShared {
    boolean isItemAvailable = false;
    ReentrantLock lock = new ReentrantLock();

    void produceItem() {
        try {
            lock.lock();
            isItemAvailable = true;
            System.out.println("Item Locked by " + Thread.currentThread().getName());
            Thread.sleep(5000); // Simulate time taken to produce an item
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println("Lock released by " + Thread.currentThread().getName());
        }
    }

    void normalMethod() {
        lock.lock();
        System.out.println("Normal method executed by " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        lock.unlock();
    }

    void prducedItemWithReentrantLock(ReentrantLock reentrantLock) {
        try {
            reentrantLock.lock();
            isItemAvailable = true;
            System.out.println("Item Locked by " + Thread.currentThread().getName());
            Thread.sleep(5000); // Simulate time taken to produce an item
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
            System.out.println("Lock released by " + Thread.currentThread().getName());
        }
    }

    void consumerReadLockOnly(ReadWriteLock readWriteLock) {
        try {
            readWriteLock.readLock().lock();
            System.out.println("Read lock acquired by " + Thread.currentThread().getName());
            Thread.sleep(3000); // Simulate time taken to consume an item
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
            System.out.println("Read lock released by " + Thread.currentThread().getName());
        }

    }
    void consumerWriteLockOnly(ReadWriteLock readWriteLock) {
        try {
            readWriteLock.writeLock().lock();
            System.out.println("Write lock acquired by " + Thread.currentThread().getName());
            Thread.sleep(3000); // Simulate time taken to consume an item
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
            System.out.println("Write lock released by " + Thread.currentThread().getName());
        }

    }

}

public class LockTypeTest {
    public static void main(String[] args) {
        LockTypeTestShared sharedResource = new LockTypeTestShared();
        // ReentrantLock reentrantLock = new ReentrantLock();
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        Thread producerThread1 = new Thread(() -> {
            sharedResource.produceItem();
            // sharedResource.prducedItemWithReentrantLock(reentrantLock);
            // sharedResource.consumerReadLockOnly(readWriteLock);
        }, "Producer-1");
        Thread producerThread2 = new Thread(() -> {
            sharedResource.produceItem();
            // sharedResource.prducedItemWithReentrantLock(reentrantLock);
            // sharedResource.consumerWriteLockOnly(readWriteLock);
        }, "Producer-2");
        Thread producerThread3 = new Thread(() -> {
            sharedResource.normalMethod();
            // sharedResource.produceItem();
            // sharedResource.prducedItemWithReentrantLock(reentrantLock);
            // sharedResource.consumerReadLockOnly(readWriteLock);
        }, "Producer-3");



        producerThread1.start();
        // producerThread2.start();
        producerThread3.start();
    }
}
