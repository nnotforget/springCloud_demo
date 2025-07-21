package com.spring.order;

import com.spring.order.feign.WeatherFeignClient;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WeatherTest {

    @Resource
    private WeatherFeignClient weatherFeignClient;

    @Test
    public void queryWeather() {
        String appKey = "APPCODE 93b7e19861a24c519a7548b17bc16d75";
        String token = "50b53ff8dd7d9fa320d3d3ca32cf8ed1";
        String cityId = "2182";
       // String weather = weatherFeignClient.queryWeather(appKey, token, cityId);  // 报错401 错误

        String weather = weatherFeignClient.queryWeather("101030100");  //使用 upyun.com 获取天气信息
        System.out.println(weather);
    }
}
