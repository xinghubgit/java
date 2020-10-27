package com.allen.domain.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @date 2020/10/23
 */

@Configuration
public class DbConfig {

    @Bean("allenDs")
    @ConfigurationProperties(prefix = "spring.datasource.allen")
    public DataSource allenDs() {
        return DataSourceBuilder.create().build();
    }

}
