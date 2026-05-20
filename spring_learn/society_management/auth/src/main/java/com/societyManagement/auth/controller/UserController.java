package com.societyManagement.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.societyManagement.auth.entity.UserEntity;
import com.societyManagement.auth.service.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/fetchUser")
    public UserEntity fetchUser(@RequestParam String username) {
        return userService.loadUserByUsername(username);
    }
}
