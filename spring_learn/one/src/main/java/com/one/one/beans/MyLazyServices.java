package com.one.one.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Lazy
@Service
public class MyLazyServices {
    MyLazyServices() {
        System.out.println("MyLazyServices constructor called");
    }
}
