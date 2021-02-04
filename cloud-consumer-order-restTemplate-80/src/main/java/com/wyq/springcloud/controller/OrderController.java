package com.wyq.springcloud.controller;

import com.wyq.springcloud.entity.CommonResult;
import com.wyq.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/*
 * @Author:wuyongqiang
 * @Date:2021-01-04 14:36:14:36
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    public static final String createurl = "http://CLOUD-PROVIDER-PAYMENT/payment/create";
    public static final String selecturl = "http://CLOUD-PROVIDER-PAYMENT/payment/selectOneById/";


    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(createurl+"",payment,CommonResult.class);
    }

    @GetMapping("/selectOneById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Long id){
        String url =selecturl+id;
        return restTemplate.getForObject(url,CommonResult.class);
    }
}
