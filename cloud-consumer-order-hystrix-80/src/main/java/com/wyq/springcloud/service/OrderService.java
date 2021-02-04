package com.wyq.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*
 * @Author:wuyongqiang
 * @Date:2021-01-08 16:05:16:05
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-PAYMENT-HYSTRIX-8003",fallback = OrderServiceFallBackImpl.class)
public interface OrderService {
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id")Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_timeout(@PathVariable("id")Integer id);
}
