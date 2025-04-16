package com.microservices.api_gateway.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

import java.net.URI;


@Configuration
public class RouterConfig {
    private static final Logger logger = LoggerFactory.getLogger(RouterConfig.class);

    @Bean
    public RouteLocator userServiceRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user-service", r -> r
                        .path("/users/**")
                        .filters(f -> f
                                .rewritePath("/users/(?<segment>.*)", "/${segment}")
                        )
                        .uri("http://localhost:8086")
                )
                .build();
    }

    @Bean
    public RouteLocator productServiceRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("product-service", r -> r
                        .path("/products/**")
                        .filters(f -> f
                                .rewritePath("/products/(?<segment>.*)", "/${segment}")
                        )
                        .uri("http://localhost:8085")
                )
                .build();
    }

    @Bean
    public RouteLocator servicesSwaggerRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("product-service-swagger", r -> r
                        .path("/aggregate/product-service/api-docs")
                        .filters(f -> f
                                .setPath("/api-docs")
                        )
                        .uri("http://localhost:8085")
                )
                .route("order-service-swagger", r -> r
                        .path("/aggregate/order-service/api-docs")
                        .filters(f -> f
                            .setPath("/api-docs")
                        )
                        .uri("http://localhost:8081")
                )
                .route("user-service-swagger", r -> r
                        .path("/aggregate/user-service/api-docs")
                        .filters(f -> f
                                .setPath("/api-docs")
                        )
                        .uri("http://localhost:8086")
                )
                .route("supplier-service-swagger", r -> r
                        .path("/aggregate/supplier-service/api-docs")
                        .filters(f -> f
                                .setPath("/api-docs")
                        )
                        .uri("http://localhost:8083")
                )
                .route("coupon-service-swagger", r -> r
                        .path("/aggregate/coupon-service/api-docs")
                        .filters(f -> f
                                .setPath("/api-docs")
                        )
                        .uri("http://localhost:8084")
                )
                .route("consumer-service-swagger", r -> r
                        .path("/aggregate/consumer-service/api-docs")
                        .filters(f -> f
                                .setPath("/api-docs")
                        )
                        .uri("http://localhost:8082")
                )
                .build();
    }



}

