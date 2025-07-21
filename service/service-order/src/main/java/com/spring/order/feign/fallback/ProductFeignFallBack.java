package com.spring.order.feign.fallback;

import java.math.BigDecimal;

import com.spring.order.feign.ProductFeignClient;
import com.spring.order.product.bean.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 订单服务-商品服务-FeignClient 兜底返回
 */
@Slf4j
@Component
public class ProductFeignFallBack implements ProductFeignClient {

    @Override
    public Product queryByProductId(String productId, String token) {
        log.info("兜底回调...");
        Product product = new Product();
        product.setId(Long.parseLong(productId));
        product.setProductName("兜底-商品名称");
        product.setPrice(new BigDecimal("190"));
        product.setNum(0);
        return product;
    }
}
