package com.wyq.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * @Author:wuyongqiang
 * @Date:2021-01-12 11:07:11:07
 */
@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder locatorBuilder){
        RouteLocatorBuilder.Builder routes =  locatorBuilder.routes();
        routes.route("path-8001",r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        routes.route("path-8002",r -> r.path("/guoji").uri("http://news.baidu.com/guoji")).build();
        return routes.build();
    }
}
