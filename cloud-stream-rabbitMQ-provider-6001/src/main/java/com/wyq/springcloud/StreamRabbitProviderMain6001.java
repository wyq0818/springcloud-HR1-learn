package com.wyq.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/*
 * @Author:wuyongqiang
 * @Date:2021-01-15 14:04:14:04
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamRabbitProviderMain6001 {
    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitProviderMain6001.class,args);
    }
}
