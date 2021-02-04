package com.wyq.springcloud.controller;

import com.wyq.springcloud.entity.CommonResult;
import com.wyq.springcloud.entity.Payment;
import com.wyq.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/*
 * @Author:wuyongqiang
 * @Date:2021-01-04 14:36:14:36
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {


    @Value("${server.port}")
    private String serverPort;
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create")
    public CommonResult create(Payment payment){
        int i = paymentService.create(payment);
        if(i>0){
            return new CommonResult(200,"success"+serverPort,i);
        }else{
            return new CommonResult(444,"fail"+serverPort,i);
        }
    }
    @GetMapping("/selectList")
    public String list(){
        return serverPort;
    }
    @GetMapping("/selectOneById/{id}")
    public CommonResult getPayMentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        if(payment!=null){
            return  new CommonResult(200,"success8002"+serverPort,payment);
        }else{
            return  new CommonResult(444,"fail"+serverPort,null);
        }
    }
}
