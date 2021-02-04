package com.wyq.springcloud.controller;

import com.wyq.springcloud.entity.CommonResult;
import com.wyq.springcloud.entity.Payment;
import com.wyq.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * @Author:wuyongqiang
 * @Date:2021-01-04 14:36:14:36
 */
@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private DiscoveryClient discoveryClient;

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
            return  new CommonResult(200,"success"+serverPort,payment);
        }else{
            return  new CommonResult(444,"fail"+serverPort,null);
        }
    }

    @GetMapping("/discovery")
    public Object getDiscovery(){
        List<String> serviceList =  discoveryClient.getServices();
        for (String element:serviceList) {
            log.info("*****element****"+element);
        }
        List<ServiceInstance> serviceInstanceList =  discoveryClient.getInstances("CLOUD-PROVIDER-PAYMENT");
        for (ServiceInstance instance:serviceInstanceList) {
            log.info("*****instance****:"+instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }
}
