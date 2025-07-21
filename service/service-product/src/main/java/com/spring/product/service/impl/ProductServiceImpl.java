package com.spring.product.service.impl;
import com.spring.order.product.bean.Product;
import java.math.BigDecimal;

import com.spring.product.service.ProductService;
import java.util.concurrent.TimeUnit;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public Product queryProductById(String productId) {
        Product product=new Product();
        product.setId(Long.parseLong(productId));
        product.setProductName("测试商品");

        //商品价格
        product.setPrice(new BigDecimal("99"));
        product.setNum(2);

        try {
            TimeUnit.SECONDS.sleep(100);  //测试 超时， 100秒
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return product;
    }
}
