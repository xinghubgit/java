package com.allen.svc.config;

import com.allen.svc.annotation.ConditionalOnSystemProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @date 2020/11/16
 */

@Configuration
public class HelloConfiguration {

    @Bean
    @ConditionalOnSystemProperties(name = "user.name", value = "allen.jin")
    public String hello() {
        return "Hello Auto Config.";
    }

}
