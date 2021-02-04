package com.wyq.springcloud.srevice;/*
 * @Author:wuyongqiang
 * @Date:2021-01-07 15:17:15:17
 */

import com.wyq.springcloud.entity.CommonResult;
import com.wyq.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PROVIDER-PAYMENT")//指明调用的服务
public interface PaymentFeignService {

    @GetMapping("/payment/selectOneById/{id}")//指明调用的url
    public Payment aaa(@PathVariable("id") Long id);//保证方法的参数和返回值与调用接口一致即可，本地方法名无所谓


    @GetMapping("/payment/timeout")//指明调用的url
    public String timeOut();//保证方法的参数和返回值与调用接口一致即可，本地方法名无所谓

}
