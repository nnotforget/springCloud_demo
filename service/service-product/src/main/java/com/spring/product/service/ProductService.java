package com.spring.product.service;


import com.spring.order.product.bean.Product;

public interface ProductService {

    Product queryProductById(String productId);
}
