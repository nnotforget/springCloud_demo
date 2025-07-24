package com.spring.order.controller;

import com.spring.order.bean.Order;
import com.spring.order.properties.OrderProperties;
import com.spring.order.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RefreshScope   //自动刷新
//@RequestMapping("/api/order")   // 通过gateway网关 过滤器实现
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @Resource
    private OrderProperties orderProperties;

    @GetMapping("/config")
    public String config() {
        System.out.println("config...");
        return "order.timeout:" + orderProperties.getTimeOut() + ", " +
                "order.auto-confirm:" + orderProperties.getAutoConfirm() + "," +
                "order.db-url:" + orderProperties.getDbUrl();
    }

    @GetMapping("/create")
    public Order createOrder(@RequestParam("productId") String productId,
                             @RequestParam("userId") String userId) {
        return orderService.createOrder(productId, userId);
    }

    @GetMapping("/readDb")
    public String readDb() {
        System.out.println("readDb...");
        return "readDB success...";
    }
}
