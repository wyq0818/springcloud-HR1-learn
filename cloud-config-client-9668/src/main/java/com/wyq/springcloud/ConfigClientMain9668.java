package com.wyq.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/*
 * @Author:wuyongqiang
 * @Date:2021-01-14 13:52:13:52
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientMain9668 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain9668.class,args);
    }
}
