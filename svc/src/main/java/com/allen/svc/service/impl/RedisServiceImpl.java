package com.allen.svc.service.impl;

import com.allen.svc.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.ClusterOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.types.RedisClientInfo;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @date 2020/10/26
 */

@Slf4j
@Service
public class RedisServiceImpl implements RedisService {

    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public String testRedis() {
        List<RedisClientInfo> clientList = redisTemplate.getClientList();
        redisTemplate.setKeySerializer(new StringRedisSerializer());

        ClusterOperations clusterOperations = redisTemplate.opsForCluster();
        ValueOperations operations = redisTemplate.opsForValue();
        operations.setIfPresent("allen-test", "HelloWorld");
        return (String)operations.get("allen-test");
    }
}
