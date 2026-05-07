package com.AOP.aopTest.Async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.AOP.aopTest.TransactionalTest.TransactionalServices;

@Service
public class MyAsyncService {

    @Autowired
    TransactionalServices transactionalServices;

    @Async("taskPoolExecutor")
    public void fetchUser() {
        System.out.println("fetchUser method called in MyAsyncService " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000); // Simulate a delay in fetching user data
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public void deleteUser() {
        System.out.println("deleteUser method called in MyAsyncService " + Thread.currentThread().getName());
        // txnal will not carry-forward to another thread. Hence, deleteUser will
        // execute in a different thread without transactional context.
        transactionalServices.deleteUser();
    }
}
