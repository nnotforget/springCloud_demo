package com.spring.gateway.filter;

import java.util.UUID;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractNameValueGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * 自定义gateway过滤器工厂
 */
@Component
public class TokenGatewayFilterFactory extends AbstractNameValueGatewayFilterFactory {

    @Override
    public GatewayFilter apply(NameValueConfig config) {
        return (exchange, chain) -> chain.filter(exchange).then(Mono.fromRunnable(() -> {
            System.out.println("请求路径：" + exchange.getRequest().getURI());
            String value = config.getValue();
            if (value.equals("uuid")) {
                value = UUID.randomUUID().toString();
            }
            if (value.equals("jwt")) {
                value = "jwt-token";
            }
            exchange.getResponse().getHeaders().add(config.getName(), value);
        }));
    }
}
