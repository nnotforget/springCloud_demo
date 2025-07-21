package com.spring.order.config;

import feign.Logger;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OrderConfig {

    @Bean
    Logger.Level level() {
        return Logger.Level.FULL;
    }

    @Bean
    @LoadBalanced  // 注解式-自动获取配置中心 负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
