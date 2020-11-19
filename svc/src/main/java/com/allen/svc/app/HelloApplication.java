package com.allen.svc.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @date 2020/11/16
 */

@ComponentScan(basePackages = "com.allen.svc")
public class HelloApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(HelloApplication.class)
                .web(WebApplicationType.NONE)
                .profiles("java8")
                .run(args);

        System.out.println("Context Class : " + applicationContext.getClass().getName());
        System.out.println("Environment Class : " + applicationContext.getEnvironment().getClass().getName());

        String hello = applicationContext.getBean("hello", String.class);
        System.out.println("Hello Auto Config : " + hello);

        applicationContext.close();
    }
}
