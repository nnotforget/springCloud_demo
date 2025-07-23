package com.spring.product.controller;

import com.spring.order.product.bean.Product;
import com.spring.product.service.ProductService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/product")
public class productController {

    @Resource
    private ProductService productService;

    @RequestMapping("/product/{id}")
    public Product queryByProductId(@PathVariable("id") String productId,
                                    HttpServletRequest request) {
        String token = request.getHeader("X-Token");
        log.info("查询商品id:{}  {}", productId, token);
        return productService.queryProductById(productId);
    }
}
