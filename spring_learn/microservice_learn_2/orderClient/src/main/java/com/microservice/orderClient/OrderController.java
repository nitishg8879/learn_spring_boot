package com.microservice.orderClient;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/getProducts")
    public String getProducts() {
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("product-service");
        URI productServiceUri = instances.get(0).getUri();
        String productServiceUrl = productServiceUri.toString() + "/products";
        return restTemplate.getForObject(productServiceUrl, String.class);
    }

}
