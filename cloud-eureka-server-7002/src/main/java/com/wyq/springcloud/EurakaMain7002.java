package com.wyq.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/*
 * @Author:wuyongqiang
 * @Date:2021-01-06 10:14:10:14
 */
@SpringBootApplication
@EnableEurekaServer
public class EurakaMain7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurakaMain7002.class,args);
    }
}
