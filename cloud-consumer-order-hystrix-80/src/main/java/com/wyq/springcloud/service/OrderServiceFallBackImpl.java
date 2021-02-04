package com.wyq.springcloud.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/*
 * @Author:wuyongqiang
 * @Date:2021-01-11 10:25:10:25
 */
@Component
@Slf4j
public class OrderServiceFallBackImpl implements  OrderService{
    @Override
    public String paymentInfo_ok(Integer id) {
        return null;
    }

    @Override
    public String paymentInfo_timeout(Integer id) {
        log.info("消费者等待超时，继续熔断");
        return "线程池："+Thread.currentThread().getName()+"paymentInfo_TimeOutHandler,生产者服务不可用,全局配置实现类，超时降级";
    }
}
