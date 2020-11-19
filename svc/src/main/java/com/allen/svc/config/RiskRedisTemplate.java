package com.allen.svc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @date 2020/11/10
 */

@Configuration
public class RiskRedisTemplate {

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public <T> T getKey(Class<T> t, String key) {
//        redisTemplate.op

        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        valueOperations.set("java:allen", "test");
//        HashOperations hashOperations = redisTemplate.opsForHash();
//        ArrayList<String> csfIds = new ArrayList<>();
//        List<T> list = hashOperations.multiGet(key, csfIds);
        return null;
    }


}
