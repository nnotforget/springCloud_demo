package com.spring;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.nacos.api.config.listener.Listener;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。

@EnableFeignClients //开启openFeign 远程调用功能
@SpringBootApplication
@EnableDiscoveryClient
public class OrderMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderMainApplication.class, args);
    }

    // 项目启动，则监听配置文件，是否发生了变化，邮件通知
    @Bean
    ApplicationRunner run(NacosConfigManager nacosConfigManager) {
        return args -> {
            System.out.println("ApplicationRunner 启动成功");
            // 监听配置文件
            nacosConfigManager.getConfigService().addListener("service-order.properties",
                    "DEFAULT_GROUP", new Listener() {
                        @Override
                        public Executor getExecutor() {
                            return Executors.newFixedThreadPool(3);
                        }

                        @Override
                        public void receiveConfigInfo(String s) {
                            System.out.println("配置文件发生改变:" + s);

                            System.out.println("邮件通知...");
                        }
                    });
        };
    }
}