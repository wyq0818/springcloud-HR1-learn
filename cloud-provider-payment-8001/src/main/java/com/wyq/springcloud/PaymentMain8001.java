package com.wyq.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/*
 * @Author:wuyongqiang
 * @Date:2021-01-04 14:02:14:02
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentMain8001{
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class,args);
    }
    /**
     * 此配置是为了服务监控配置，与服务容错本身无关，Springcloud升级后的坑
     * 因为springboot的默认路径不是"/hystris.stream",
     * 只要在自己的项目里配置上下面的servlet就可以了
     * @return
     */
    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean servletRegistrationBean =  new ServletRegistrationBean(streamServlet);
        servletRegistrationBean.setLoadOnStartup(1);
        servletRegistrationBean.addUrlMappings("/hystrix.stream");
        servletRegistrationBean.setName("HystrixMetricsStreamServlet");
        return servletRegistrationBean;
    }
}
