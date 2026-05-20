package com.societyManagement.members.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.society.common.service.JwtService;

@Configuration
public class AppConfig {
    @Bean
    JwtService jwtService() {
        return new JwtService();
    }
}
