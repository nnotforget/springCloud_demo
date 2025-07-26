package com.spring.product.job;

import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SampleJob {

    @XxlJob("sampleJobHandler")
    public void sampleJobHandler() throws Exception {
        log.info("Sample Job is running...");
        // 这里编写具体的任务逻辑，例如查询数据库、发送邮件等
        System.out.println("执行具体任务操作");
    }
}
