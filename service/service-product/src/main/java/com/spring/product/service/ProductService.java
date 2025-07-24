package com.spring.product.service;


import com.spring.product.bean.Product;

public interface ProductService {

    Product queryProductById(String productId);
}
