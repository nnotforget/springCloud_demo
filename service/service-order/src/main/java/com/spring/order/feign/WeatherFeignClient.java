package com.spring.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

// http://t.weather.sojson.com/api/weather/city/101030100


//@FeignClient(value = "weather-client", url = "http://aliv18.data.moji.com")\
@FeignClient(value = "weather-client", url = "http://t.weather.sojson.com")
public interface WeatherFeignClient {


    @PostMapping("/whapi/json/alicityweather/condition")
    String queryWeather(@RequestHeader("Authorization") String auth,
                        @RequestParam("token") String token,
                        @RequestParam("cityId") String cityId);

    @GetMapping("/api/weather/city/{cityId}")
    String queryWeather(@PathVariable("cityId") String cityId);
}
