package com.wyq.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/*
 * @Author:wuyongqiang
 * @Date:2021-01-08 16:04:16:04
 */
@SpringBootApplication
@EnableEurekaClient//服务注册
@EnableFeignClients//服务调用
@EnableHystrix//服务降级
@EnableCircuitBreaker//断路器
public class OrderHystrixMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain80.class,args);
    }
}
