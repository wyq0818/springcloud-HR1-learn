package com.wyq.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/*
 * @Author:wuyongqiang
 * @Date:2021-01-12 17:10:17:10
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class ConfigServerMain {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerMain.class,args);
    }
}
