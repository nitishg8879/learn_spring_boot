package java_learn.thread;

import java.util.LinkedList;
import java.util.Queue;

public class NewTHreadTestShared {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int capacity = 5;

    public synchronized void produce(int value) throws InterruptedException {
        while (queue.size() == capacity) {
            System.out.println("Buffer full, producer waiting...");
            wait(); // releases lock
        }

        queue.add(value);
        System.out.println("Produced: " + value);

        notify(); // wake up consumer
    }

    public synchronized int consume() throws InterruptedException {
        while (queue.isEmpty()) {
            System.out.println("Buffer empty, consumer waiting...");
            wait(); // releases lock
        }

        int value = queue.poll();
        System.out.println("Consumed: " + value);

        notify(); // wake up producer
        return value;
    }
}


class NewTHreadText {
    public static void main(String[] args) {
        NewTHreadTestShared sharedResource = new NewTHreadTestShared();

        Thread producerThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    sharedResource.produce(i);
                    Thread.sleep(100); // Simulate time taken to produce an item
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumerThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    sharedResource.consume();
                    Thread.sleep(150); // Simulate time taken to consume an item
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}