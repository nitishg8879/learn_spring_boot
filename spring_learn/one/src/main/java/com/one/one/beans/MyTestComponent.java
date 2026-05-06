package com.one.one.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class MyTestComponent {

    @Autowired
    private MyLazyServices myLazyServices;
    @Autowired
    private MyReqLazyService myService3;

    @PostConstruct
    void postConstruct() {
        System.out.println("MyTestComponent postConstruct called");
    }

    private MyTestComponent(){
        System.out.println("MyTestComponent constructor called");
    }
}
