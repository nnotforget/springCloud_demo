package com.spring.order.service.impl;
import com.spring.order.product.bean.Product;
import java.math.BigDecimal;

import com.spring.order.service.ProductService;
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

        return product;
    }
}
