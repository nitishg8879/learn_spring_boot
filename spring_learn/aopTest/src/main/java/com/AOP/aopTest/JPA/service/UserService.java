package com.AOP.aopTest.JPA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AOP.aopTest.JPA.entity.UserDetails;
import com.AOP.aopTest.JPA.repo.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public void saveUser() {
        UserDetails user = UserDetails.builder().email("nitin@example.com").password("password123").build();
        userRepo.save(user);
    }
}
