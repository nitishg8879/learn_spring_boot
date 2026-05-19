package main.java.com.gateway.ApiGateway;
// package com.gateway.ApiGateway;

public class JwtAuthGlobalFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // Implement JWT authentication logic here
        // For example, you can extract the JWT token from the Authorization header,
        // validate it, and set the authentication context if valid.

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        // Set the order of this filter. Lower values have higher precedence.
        return -1; // You can adjust this value based on your needs
    }
    
}
