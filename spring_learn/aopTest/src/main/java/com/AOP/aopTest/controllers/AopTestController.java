package com.AOP.aopTest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/aop")
public class AopTestController {

    @GetMapping("/beforeTest")
    public String beforeTest() {
        return "AOP Test";
    }

    @GetMapping("/afterTest")
    public String afterTest() {
        return new String();
    }

    @GetMapping("/aroundTest")
    public String aroundTest(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

}
