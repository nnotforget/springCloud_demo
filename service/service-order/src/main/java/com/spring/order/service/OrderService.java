package com.spring.order.service;


import com.spring.order.bean.Order;

public interface OrderService {

    Order createOrder(String productId, String userId);
}
