package com.wyq.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/*
 * @Author:wuyongqiang
 * @Date:2021-01-13 10:30:10:30
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientMain9667 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain9667.class,args);
    }
}
