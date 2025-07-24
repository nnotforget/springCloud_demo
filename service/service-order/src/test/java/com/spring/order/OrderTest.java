package com.spring.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

@SpringBootTest
public class OrderTest {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Test
    public void orderTest(){
        ServiceInstance serviceInstance =  loadBalancerClient.choose( "service-product");
        System.out.println("服务地址：" + serviceInstance.getHost()+":"+serviceInstance.getPort());
        serviceInstance =  loadBalancerClient.choose( "service-product");
        System.out.println("服务地址：" + serviceInstance.getHost()+":"+serviceInstance.getPort());
        serviceInstance =  loadBalancerClient.choose( "service-product");
        System.out.println("服务地址：" + serviceInstance.getHost()+":"+serviceInstance.getPort());
        serviceInstance =  loadBalancerClient.choose( "service-product");
        System.out.println("服务地址：" + serviceInstance.getHost()+":"+serviceInstance.getPort());
        serviceInstance =  loadBalancerClient.choose( "service-product");
        System.out.println("服务地址：" + serviceInstance.getHost()+":"+serviceInstance.getPort());
        serviceInstance =  loadBalancerClient.choose( "service-product");
        System.out.println("服务地址 ：" + serviceInstance.getHost()+":"+serviceInstance.getPort());
        serviceInstance =  loadBalancerClient.choose( "service-product");
        System.out.println("服务地址：" + serviceInstance.getHost()+":"+serviceInstance.getPort());
    }
}
