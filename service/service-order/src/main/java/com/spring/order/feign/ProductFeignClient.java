package com.spring.order.feign;

import com.spring.order.feign.fallback.ProductFeignFallBack;
import com.spring.product.bean.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "service-product",  // feign 客户端  value=指定 nacos 注册的微服务名称
        contextId = "product-feignClient",
        fallback = ProductFeignFallBack.class)  // 调用失败，则返回 兜底数据信息
public interface ProductFeignClient {

    @GetMapping("/product/{id}")
    Product queryByProductId(@PathVariable("id") String productI, @RequestHeader("token") String token);

}
