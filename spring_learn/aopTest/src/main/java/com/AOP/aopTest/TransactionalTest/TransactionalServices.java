package com.AOP.aopTest.TransactionalTest;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class TransactionalServices {

    @Transactional(propagation = Propagation.REQUIRED)
    public String fetchUsers(String param) {
        return new String();
    }


    @Async
    public void deleteUser() {
        System.out.println("deleteUser method called in TransactionalServices " + Thread.currentThread().getName());
    }
}
