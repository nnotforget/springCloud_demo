package com.spring.gateway.predicate;

import jakarta.validation.constraints.NotEmpty;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

/**
 * 自定义路由断言工厂
 */
@Component
public class VipRoutePredicateFactory extends AbstractRoutePredicateFactory<VipRoutePredicateFactory.Config> {

    /**
     * 配置参数顺序
     *
     * @return List
     */
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("param", "value");
    }

    /**
     * 构造函数
     */
    public VipRoutePredicateFactory() {
        super(VipRoutePredicateFactory.Config.class);
    }

    /**
     * 创建断言
     *
     * @param config 配置参数
     * @return Predicate
     */
    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return serverWebExchange -> {
            String param = serverWebExchange.getRequest().getQueryParams().getFirst(config.getParam());
            return StringUtils.hasText(param) && param.equals(config.getValue());
        };
    }

    /**
     * 配置参数
     */
    @Validated
    public static class Config {
        private @NotEmpty String param;
        private @NotEmpty String value;

        public String getParam() {
            return this.param;
        }

        public Config setParam(String param) {
            this.param = param;
            return this;
        }

        public String getValue() {
            return this.value;
        }

        public Config setValue(String value) {
            this.value = value;
            return this;
        }

    }
}
