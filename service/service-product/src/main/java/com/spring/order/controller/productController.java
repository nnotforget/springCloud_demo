package com.spring.order.controller;

import com.spring.order.product.bean.Product;
import com.spring.order.service.ProductService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class productController {

    @Resource
    private ProductService productService;

    @RequestMapping("/product/{id}")
    public Product queryByProductId(@PathVariable("id") String productId) {
        log.info("查询商品id:{}", productId);
        return productService.queryProductById(productId);
    }
}
