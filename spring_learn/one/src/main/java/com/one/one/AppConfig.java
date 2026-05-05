package com.one.one;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

// @Configuration
// @EnableWebMvc
// @ComponentScan(basePackages = "com.one.one")
@Configuration
public class AppConfig {
    @Bean
    MyUser myUser() {
        return new MyUser("John", "Doe");
    }
}
