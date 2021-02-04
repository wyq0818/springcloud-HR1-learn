package com.wyq.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/*
 * @Author:wuyongqiang
 * @Date:2021-01-15 15:52:15:52
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamRabbitConsumer6002 {
    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitConsumer6002.class,args);
    }
}
