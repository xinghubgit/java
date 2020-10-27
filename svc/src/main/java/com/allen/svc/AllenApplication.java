package com.allen.svc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @date 2020/10/23
 */

@SpringBootApplication
@ComponentScan(basePackages = {"com.allen.domain", "com.allen.svc", "com.allen.redis", "com.allen.es"})
public class AllenApplication {
    public static void main(String[] args) {
        SpringApplication.run(AllenApplication.class, args);
    }
}
