package com.spring.order.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import java.util.UUID;
import org.springframework.stereotype.Component;

/**
 * openFeign 拦截器
 */
@Component
public class XTokenRequestInterceptor implements RequestInterceptor {

    /**
     * 请求拦截
     *
     * @param requestTemplate 请求模板
     */
    @Override
    public void apply(RequestTemplate requestTemplate) {
        System.out.println("openFeign XTokenRequestInterceptor 拦截器...");
        requestTemplate.header("X-Token", UUID.randomUUID().toString());
    }
}
