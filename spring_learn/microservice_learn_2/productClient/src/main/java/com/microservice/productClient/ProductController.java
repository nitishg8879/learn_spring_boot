package com.microservice.productClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/products")
@RestController
public class ProductController {
    @GetMapping("/{id}")
    public String fetchProduct(@PathVariable("id") String id) {
        return "Hello, this is product with id: " + id + " from product service";
    }

}
