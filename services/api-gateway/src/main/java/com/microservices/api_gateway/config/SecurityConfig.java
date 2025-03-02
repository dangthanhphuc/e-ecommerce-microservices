package com.microservices.api_gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    private final String[] freeResourceUrl = {
            "/swagger-ui.html",
            "/swagger-ui/**",
//            "/webjars/swagger-ui/**",
            "/api-docs/**",
            "/v3/api-docs/**",
            "/aggregate/**",
            "/actuator/**"
    };

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity serverHttpSecurity) throws Exception {
        return serverHttpSecurity
                .authorizeExchange(
                        authorizeExchangeSpec -> authorizeExchangeSpec
                                .pathMatchers(freeResourceUrl).permitAll()
                                .anyExchange().authenticated()
                )
                .csrf(Customizer.withDefaults())
                .build();
    }

}
