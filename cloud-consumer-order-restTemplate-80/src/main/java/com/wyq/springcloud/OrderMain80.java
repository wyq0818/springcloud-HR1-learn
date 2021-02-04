package com.wyq.springcloud;

import com.wyq.ribbonConfig.RibbonRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/*
 * @Author:wuyongqiang
 * @Date:2021-01-04 15:20:15:20
 */
//对于单个服务设置自定义的负载均衡策略，且改自定义配置类不能位于启动类的下层package内，否则会被分布式架构共享
@RibbonClient(name = "CLOUD-CONSUMER-ORDER-80",configuration = RibbonRuleConfig.class)
@EnableEurekaClient
@SpringBootApplication
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }
}
