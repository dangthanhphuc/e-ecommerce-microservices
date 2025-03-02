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
    public RouteLocator productServiceRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("product-service", r -> r
                        .path("/products/**")
                        .filters( f -> f.setPath(""))
                        .uri("http://localhost:8080")
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
                        .uri("http://localhost:8080")
                )
                .route("order-service-swagger", r -> r
                        .path("/aggregate/order-service/api-docs")
                        .filters(f -> f
                            .setPath("/api-docs")
                        )
                        .uri("http://localhost:8081")
                )
                .build();
    }



}

