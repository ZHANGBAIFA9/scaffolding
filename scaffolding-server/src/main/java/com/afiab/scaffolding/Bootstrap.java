package com.afiab.scaffolding;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/7/21 17:22
 * @Description:
 */
@SpringBootApplication(scanBasePackages={"com.afiab.scaffolding"}) // 注意启动类一般起名 Bootstrap
@SpringCloudApplication
public class Bootstrap {
    private static final Logger log = LoggerFactory.getLogger(Bootstrap.class);
    public static void main(String[] args) {
        SpringApplication.run(Bootstrap.class, args);
        log.info("Bootstrap started successfully");
    }
}
