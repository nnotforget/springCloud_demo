package com.spring.order.service;


import com.spring.order.product.bean.Product;

public interface ProductService {

    Product queryProductById(String productId);
}
