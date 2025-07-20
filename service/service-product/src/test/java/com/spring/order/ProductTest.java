package com.spring.order;

import com.alibaba.cloud.nacos.discovery.NacosServiceDiscovery;
import com.alibaba.nacos.api.exception.NacosException;
import com.spring.ProductMainApplication;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

@SpringBootTest
public class ProductTest {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private NacosServiceDiscovery nacosServiceDiscovery;


    @Test
    public void NacosTest() throws NacosException {
        List<String> services = nacosServiceDiscovery.getServices();
        for(String service : services){
            System.out.println(service);
            List<ServiceInstance> serviceInstances =  nacosServiceDiscovery.getInstances(service);
            for(ServiceInstance serviceInstance : serviceInstances){
                System.out.println(serviceInstance.getHost() + ":" + serviceInstance.getPort());
            }
        }

    }

    @Test
    public void DiscoveryTest() {
        List<String> services = discoveryClient.getServices();
        for(String service : services){
            System.out.println(service);
            List<ServiceInstance> serviceInstances =  discoveryClient.getInstances(service);
            for(ServiceInstance serviceInstance : serviceInstances){
                System.out.println(serviceInstance.getHost() + ":" + serviceInstance.getPort());
            }
        }

    }
    public static void main(String[] args) {
        ProductMainApplication.main(args);
    }
}
