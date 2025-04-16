package com.microservices.api_gateway.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Configuration
@EnableWebFluxSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthConverter jwtAuthConverter;

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity serverHttpSecurity) throws Exception {
        return serverHttpSecurity
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .authorizeExchange(
                        authorizeExchangeSpec -> authorizeExchangeSpec
                                .pathMatchers(
                                        "/users/register",
                                        "/users/login",
                                        //healthcheck
                                        "/healthcheck/**",
                                        //swagger
                                        "/v3/api-docs",
                                        "/v3/api-docs/**",
                                        "/api-docs",
                                        "/api-docs/**",
                                        "/swagger-resources/**",
                                        "/swagger-ui/**",
                                        "/aggregate/**",
                                        "**"
                                )
                                .permitAll()
                                .anyExchange()
                                .authenticated()
                )
                .oauth2ResourceServer( oAuth2ResourceServerSpec -> { oAuth2ResourceServerSpec
                        .jwt( jwt -> jwt.jwtAuthenticationConverter(jwtAuthConverter));
                })
                .build();
    }


}
