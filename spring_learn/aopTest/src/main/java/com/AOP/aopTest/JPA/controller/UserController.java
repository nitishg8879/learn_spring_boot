package com.AOP.aopTest.JPA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AOP.aopTest.JPA.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/createUser")
    public ResponseEntity<?> createUser() {
        userService.saveUser();
        return ResponseEntity.ok("User created successfully");
    }

}
