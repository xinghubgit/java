package com.allen.svc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.ClusterOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.client.RestTemplate;

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

    public <T> T getKey(Class<T> t, String key) {
        HashOperations hashOperations = redisTemplate.opsForHash();
        ArrayList<String> csfIds = new ArrayList<>();
        List<T> list = hashOperations.multiGet(key, csfIds);
        return null;
    }


}
