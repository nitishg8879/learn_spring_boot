package com.AOP.aopTest.Async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MyAsyncService {

    @Async
    public void fetchUser() {
        System.out.println("fetchUser method called in MyAsyncService " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000); // Simulate a delay in fetching user data
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
