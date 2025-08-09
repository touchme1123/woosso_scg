package com.shpark.woosso.scg.component;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class G1Filter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        System.out.println("G1Filter Start");

        return chain.filter(exchange)
                .then(Mono.fromRunnable(() -> {
                    System.out.println("G1Filter MSA Start");
        }));
    }

    //Filter 순번 설정
    @Override
    public int getOrder() {
        return -1;
    }
}
