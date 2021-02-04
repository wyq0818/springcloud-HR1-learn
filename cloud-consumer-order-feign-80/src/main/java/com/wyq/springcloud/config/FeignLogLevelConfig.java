package com.wyq.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * @Author:wuyongqiang
 * @Date:2021-01-08 11:00:11:00
 * feign服务调用的日志监控和输出控制，起到对接口可用性的一个监控作用
 *
 */
@Configuration
public class FeignLogLevelConfig {

    @Bean
    Logger.Level feignLogLevelConfig(){
        return Logger.Level.FULL;
    }

//    /**
//     * No logging.
//     */
//    NONE,
//    /**
//     * Log only the request method and URL and the response status code and execution time.
//     */
//    BASIC,
//    /**
//     * Log the basic information along with request and response headers.
//     */
//    HEADERS,
//    /**
//     * Log the headers, body, and metadata for both requests and responses.
//     */
//    FULL
}
