package com.societyManagement.auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.societyManagement.auth.service.UserService;

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/public")
@AllArgsConstructor
public class AuthController {
    private final UserService userService;

    @GetMapping("/create")
    public ResponseEntity<?> create(@RequestParam String username, @RequestParam String password,
            @RequestParam String email,
            @RequestParam String role) {
        return ResponseEntity.ok(userService.createUser(username, password, email, role));
    }

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
        return ResponseEntity.ok(userService.login(username, password));
    }

}
