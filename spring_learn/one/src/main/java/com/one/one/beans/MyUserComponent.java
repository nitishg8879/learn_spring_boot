package com.one.one.beans;

import org.springframework.stereotype.Component;

// to over came this issue we can use @Bean in configuration class and create
// object of this class and return it
@Component
public class MyUserComponent {
    private String name;

    public MyUserComponent(String name) {
        this.name = name;
        System.out.println("MyUserComponent constructor called with name: " + name);
    }
}
