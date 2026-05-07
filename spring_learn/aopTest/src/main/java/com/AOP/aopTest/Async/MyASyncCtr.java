package com.AOP.aopTest.Async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/async")
public class MyASyncCtr {
    @Autowired
    private MyAsyncService myAsyncService;

    @GetMapping("/fetchUser")
    public void fetchUser() {
        System.out.println("fetchUser method called in MyASyncCtr " + Thread.currentThread().getName());
        myAsyncService.fetchUser();
    }

    @DeleteMapping
    void deleteUser() {
        System.out.println("deleteUser method called in MyASyncCtr " + Thread.currentThread().getName());
        myAsyncService.deleteUser();
    }

}
