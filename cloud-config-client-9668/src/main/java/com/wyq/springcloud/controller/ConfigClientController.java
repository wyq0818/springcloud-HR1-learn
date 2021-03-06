package com.wyq.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @Author:wuyongqiang
 * @Date:2021-01-14 13:54:13:54
 */
@RestController
@RefreshScope //实时刷新配置
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/getConfigInfo")
    public String getConfigInfo(){
        return  "9668从配置中心获取的配置为："+this.configInfo;
    }

}