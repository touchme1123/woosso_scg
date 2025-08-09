package com.shpark.woosso.scg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity; // WebFlux 기반 게이트웨이
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class GatewaySecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        http
                .authorizeExchange(exchanges -> exchanges
                        // 모든 요청에 대해 인증 없이 허용
                        // 게이트웨이는 인증을 백엔드 서비스로 위임합니다.
                        .anyExchange().permitAll()
                )

                .csrf(ServerHttpSecurity.CsrfSpec::disable);
        return http.build();
    }
}