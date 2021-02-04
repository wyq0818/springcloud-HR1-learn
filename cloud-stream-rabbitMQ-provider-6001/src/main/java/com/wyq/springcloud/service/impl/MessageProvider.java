package com.wyq.springcloud.service.impl;

import com.wyq.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.UUID;

/*
 * @Author:wuyongqiang
 * @Date:2021-01-15 15:13:15:13
 */
@Service
@EnableBinding(Source.class)//定义消息的推送管道
public class MessageProvider implements IMessageProvider {

    @Autowired
    private MessageChannel output;//消息发送管道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("**********serial:"+serial);
        return serial;
    }
}
