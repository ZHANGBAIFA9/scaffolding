package com.afiab.scaffolding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/7/21 17:22
 * @Description:
 */
@SpringBootApplication(scanBasePackages={"com.afiab.scaffolding"}) // 注意启动类一般起名 Bootstrap
//@SpringCloudApplication
public class Bootstrap {
    public static void main(String[] args) {
        SpringApplication.run(Bootstrap.class, args);
//        log.info("Bootstrap started successfully");
    }
}
