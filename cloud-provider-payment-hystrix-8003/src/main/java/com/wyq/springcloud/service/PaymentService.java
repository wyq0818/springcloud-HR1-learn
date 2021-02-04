package com.wyq.springcloud.service;/*
 * @Author:wuyongqiang
 * @Date:2021-01-08 15:30:15:30
 */

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    /**
     * 运行超时
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfo_TimeOut(Integer id){
        int time = id;
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "线程池："+Thread.currentThread().getName()+"paymentInfo_ok,id:"+id+"\t"+"消费者调用成功";
    }
    //回调方法的参数必须与业务方法相同
    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池："+Thread.currentThread().getName()+"paymentInfo_TimeOutHandler,消费者超时降级";
    }
    /**
     * 正常运行
     * @param id
     * @return
     */
    public String paymentInfo_Ok(Integer id){
        return "线程池："+Thread.currentThread().getName()+"paymentInfo_ok,id:"+id+"\t"+"***";
    }


}
