package com.microservice.order;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import feign.Response;
import feign.codec.ErrorDecoder;

@FeignClient(name = "product-service", url = "${feign.client.product-service.url}", fallback = ProductConfiguration.class)
public interface ProductClient {

    @GetMapping("/products/{id}")
    String getProductByID(@PathVariable("id") String id);
}

@Configuration
class ProductConfiguration {
    @Bean
    public ErrorDecoder feignErrorDecoder() {
        return new CustomErrorDecoder();
    }

    @Bean
    MyCutomRetryer getRetry() {
        return new MyCutomRetryer();
    }
}

class MyCutomRetryer extends feign.Retryer.Default {

    public MyCutomRetryer() {
        super(100, 1000, 4);
    }
}

class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        // : new RuntimeException("Error occurred while retrieving product details");
        return response.status() == 404 ? new RuntimeException("Product not found")
                : new RuntimeException("Error occurred while retrieving product details");
    }

}
