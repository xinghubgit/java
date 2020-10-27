package com.allen.redis.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * @date 2020/10/26
 */

@Configuration
public class RedisConfig {

    @Resource
    private RedisTemplate redisTemplate;





}
