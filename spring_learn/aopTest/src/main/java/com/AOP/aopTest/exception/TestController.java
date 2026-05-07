package com.AOP.aopTest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class TestController {

    @GetMapping
    public ResponseEntity<String> test() {
        // throw new RuntimeException("Test Exception");
        // return "test";
        return new ResponseEntity<>(
                "Bhak lavde",
                HttpStatus.BAD_REQUEST);
    }
}
