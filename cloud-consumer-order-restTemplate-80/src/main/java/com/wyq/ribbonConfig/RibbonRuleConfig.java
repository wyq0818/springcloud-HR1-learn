package com.wyq.ribbonConfig;

import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * @Author:wuyongqiang
 * @Date:2021-01-07 11:34:11:34
 */
@Configuration
public class RibbonRuleConfig {

    @Bean
    public IRule ruleConfig(){
        return new RandomRule();//随机
//        return new RoundRobinRule();//轮询
//        return new RetryRule();//先按照RoundRobinRule获取服务，如服务失败则在指定时间内重试
//        return new WeightedResponseTimeRule();// 对RoundRobinRule的扩展，响应越快的实例选择的权重更大
//        return new BestAvailableRule();//先过滤掉由于多次访问故障而处于断路器跳闸的服务，然后选择一个并发量最小的服务
//        return new AvailabilityFilteringRule();//先过滤掉故障实例，在选择并发较少的实例
//        return new ZoneAvoidanceRule();//默认规则，符合判断server所在区域的性能和server的可用性选择服务器
    }
}
