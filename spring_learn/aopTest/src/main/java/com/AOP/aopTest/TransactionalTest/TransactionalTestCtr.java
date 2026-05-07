package com.AOP.aopTest.TransactionalTest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/transactional")
public class TransactionalTestCtr {

    @Autowired
    private TransactionalServices transactionalServices;
    
    @GetMapping("/fetchUsers")
    public String fetchUsers(@RequestParam String param) {
        return new String();
    }
    
}
