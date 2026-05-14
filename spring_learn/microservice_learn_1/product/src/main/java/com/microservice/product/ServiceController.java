package com.microservice.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/products")
@RestController
public class ServiceController {
    @GetMapping("/{id}")
    public String getProduct(@PathVariable String id) {
        return "Product details for ID: " + id;
    }

}
