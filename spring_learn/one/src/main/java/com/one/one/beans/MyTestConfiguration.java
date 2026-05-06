package com.one.one.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;

@Configuration
public class MyTestConfiguration {
    @PostConstruct
    void postConstruct() {
        System.out.println("MyTestConfiguration postConstruct called");
    }

    MyTestConfiguration(){
        System.out.println("MyTestConfiguration constructor called");
    }


    @Bean
    MyUserComponent myUserComponent() {
        return new MyUserComponent("Nitin");
    }
}
