package com.spring.order.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "order")  //批量配置，无需指定 @RefreshScope
@Data
public class OrderProperties {

    private String timeOut;

    private String autoConfirm;

    private String dbUrl;
}
