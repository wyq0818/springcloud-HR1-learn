package com.wyq.springcloud.controller;

import com.wyq.springcloud.entity.CommonResult;
import com.wyq.springcloud.entity.Payment;
import com.wyq.springcloud.srevice.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/*
 * @Author:wuyongqiang
 * @Date:2021-01-08 09:34:9:34
 */
@RestController
@Slf4j
public class OrderFeignController {
    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private PaymentFeignService paymentFeignService;


    @GetMapping("/order/feign/selectOne/{id}")
    public CommonResult<Payment> getSelectOneById(@PathVariable("id") Long id){
        Payment payment = paymentFeignService.aaa(id);
        if(payment!=null){
            return  new CommonResult(200,"feign success"+serverPort,payment);
        }else{
            return  new CommonResult(444,"feign fail"+serverPort,null);
        }
    }
    @GetMapping("/order/feign/timeout")
    public String timeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally {
        }
        return paymentFeignService.timeOut();
    }

}
