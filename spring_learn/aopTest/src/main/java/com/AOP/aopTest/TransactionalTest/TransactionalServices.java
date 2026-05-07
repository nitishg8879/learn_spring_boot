package com.AOP.aopTest.TransactionalTest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class TransactionalServices {

    @Transactional(propagation = Propagation.REQUIRED)
    String fetchUsers(String param) {
        return new String();
    }
}
