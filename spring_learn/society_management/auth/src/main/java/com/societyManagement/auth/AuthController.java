package com.societyManagement.auth;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {
    private final UserService userService;

    @GetMapping("/create")
    public String create(@RequestParam String username, @RequestParam String password, @RequestParam String email,
            @RequestParam String role) {
        return userService.createUser(username, password, email, role);
    }

    

}
