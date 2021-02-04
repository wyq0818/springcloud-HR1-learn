package com.wyq.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/*
 * @Author:wuyongqiang
 * @Date:2021-01-15 16:09:16:09
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {

    @Value("${server.port}")
    private  String serverPort;

    @StreamListener(Sink.INPUT)
    public void receive(Message<String> message){
        System.out.println("消费者"+serverPort+"接受到的消息为："+message.getPayload());
    }
}
