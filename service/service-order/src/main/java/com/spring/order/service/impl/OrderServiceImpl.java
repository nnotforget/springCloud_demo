package com.spring.order.service.impl;

import com.spring.order.config.OrderConfig;
import com.spring.order.order.bean.Order;
import com.spring.order.product.bean.Product;
import jakarta.annotation.Resource;
import java.math.BigDecimal;

import com.spring.order.service.OrderService;
import java.util.Collections;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private OrderConfig orderConfig;

    @Resource
    private LoadBalancerClient loadBalancerClient;

    @Override
    public Order createOrder(String productId, String userId) {
        Product product = this.queryByProductIdWithLoadBalanceAnnotation(productId);
        BigDecimal totalAmount = product.getPrice().multiply(new BigDecimal(product.getNum()));
        Order order = new Order();
        order.setId(0L);
        order.setTotalAmount(totalAmount);
        order.setUserId(Long.parseLong(userId));
        order.setNickName("姓名-张三");
        order.setAddress("河北省廊坊市");
        order.setProductList(Collections.singletonList(product));
        return order;
    }

    /**
     * 注解式-负载均衡 -调用
     *
     * @param productId 商品ID
     * @return Product
     */
    public Product queryByProductIdWithLoadBalanceAnnotation(String productId) {
        String url = "http://service-product/product/" + productId;
        log.info("注解式-负载均衡-远程路径:{}", url);
        return orderConfig.restTemplate().getForObject(url, Product.class);
    }

    /**
     * restTemplate -调用
     *
     * @param productId 商品ID
     * @return Product
     */
    public Product queryByProductId(String productId) {
        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
        ServiceInstance instance = instances.get(0);
        // http://localhost:9000/product/1
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/product/" + productId;
        log.info("远程路径:{}", url);
        return orderConfig.restTemplate().getForObject(url, Product.class);
    }

    /**
     * 负载均衡 -调用
     *
     * @param productId 商品ID
     * @return Product
     */
    public Product queryByProductIdWithLoadBalance(String productId) {
        ServiceInstance instances = loadBalancerClient.choose("service-product");
        // ServiceInstance instance = instances.get(0);
        // http://localhost:9000/product/1
        String url = "http://" + instances.getHost() + ":" + instances.getPort() + "/product/" + productId;
        log.info("负载均衡-远程路径:{}", url);
        return orderConfig.restTemplate().getForObject(url, Product.class);
    }
}
