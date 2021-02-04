package com.wyq.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wyq.springcloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/*
 * @Author:wuyongqiang
 * @Date:2021-01-08 16:04:16:04
 */
@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "paymentInfo_TimeOutHandler")
public class OrderController {

    @Autowired
    private OrderService orderService;

    //全局接口配置断路器
    @GetMapping("/order/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否启用断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//最小请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10"),//经过多长时间允许一次请求尝试执行 秒
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50"),//请求失败比例达到多少执行熔断
    })
    public String paymentInfo_timeout(@PathVariable("id") Integer id){
        try {
            TimeUnit.SECONDS.sleep(id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  orderService.paymentInfo_timeout(id);
    }
//    回调方法的参数必须与业务方法相同
    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池："+Thread.currentThread().getName()+"paymentInfo_TimeOutHandler,生产着服务不可用,全局熔断配置，超时降级";
    }
    @GetMapping("/order/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id){
        return  orderService.paymentInfo_ok(id);
    }
    //单个接口配置断路器
//    @GetMapping("/order/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
//            //服务调用时间
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
//    })
//    public String paymentInfo_timeout(@PathVariable("id") Integer id){
//        try {
//            TimeUnit.SECONDS.sleep(id);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return  orderService.paymentInfo_timeout(id);
//    }


}
