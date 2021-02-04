package com.wyq.springcloud.config;

/**
 * 自定义网关过滤器
 *
 * @Author:wuyongqiang
 * @Date:2021-01-12 16:03:16:03
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

@Component
@Slf4j
public class CustomGatewayFilterConfig implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("***********come in CustomGatewayFilterConfig:" + new Date());
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        System.out.println("****************" + uname + "********");
        if (uname == null) {
            log.info("**********用户名为null,非法请求*****");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
