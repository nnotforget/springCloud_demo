package com.spring.order.feign;

import com.spring.order.product.bean.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "service-product", contextId = "product-feignClient")  // feign 客户端  value=指定 nacos 注册的微服务名称
public interface ProductFeignClient {

    @GetMapping("/product/{id}")
    Product queryByProductId(@PathVariable("id") String productI, @RequestHeader("token") String token);

}
