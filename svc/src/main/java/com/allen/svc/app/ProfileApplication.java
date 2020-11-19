package com.allen.svc.app;

import com.allen.svc.service.CalcService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;

/**
 * @date 2020/11/16
 */

@ComponentScan(basePackages = "com.allen.svc")
public class ProfileApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(ProfileApplication.class)
                .web(WebApplicationType.NONE)
                .profiles("java8")
                .run(args);
        CalcService calcService = applicationContext.getBean(CalcService.class);
        calcService.sum(1, 2, 3, 5);
        applicationContext.close();

    }
}
