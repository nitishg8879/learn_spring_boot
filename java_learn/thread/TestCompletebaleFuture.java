package java_learn.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class TestCompletebaleFuture {
    public static void main(String[] args) {
        System.out.println("Main thread: Start" + Thread.currentThread().getName());
        CompletableFuture<String> future  = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000); // Simulate work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "Hello from CompletableFuture!";
        }).thenApply(t -> {
            return t + " - Modified by thenApply";
        }).thenApplyAsync(t -> {
            try {
                Thread.sleep(2000); // Simulate more work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return t + " - Modified by thenApplyAsync";
        }).thenCompose(t -> {
            return CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(3000); // Simulate even more work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                return t + " - Modified by thenCompose";
            });
        });
        System.out.println("Main thread: End" + Thread.currentThread().getName());
        // List<Integer> list = new ArrayList<>();
        // list.add(1);
        // System.out.println('3'+3);
        // System.out.println(list);
    }
}
