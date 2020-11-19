package com.allen.svc.service.impl;

import com.allen.svc.entity.Company;
import com.allen.svc.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.core.types.RedisClientInfo;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @date 2020/10/26
 */

@Slf4j
@Service
public class RedisServiceImpl implements RedisService {

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public String testRedis() {
//        List<RedisClientInfo> clientList = redisTemplate.getClientList();
//        redisTemplate.setKeySerializer(new StringRedisSerializer());

//        ClusterOperations clusterOperations = redisTemplate.opsForCluster();
//        ValueOperations operations = redisTemplate.opsForValue();
//        operations.setIfPresent("allen-test", "HelloWorld");
//        Boolean delete = redisTemplate.delete("java:aget llen:hash");
//        log.info("Delete Key : {}", delete);
//        HashOperations hashOperations = redisTemplate.opsForHash();
//        hashOperations.put("java:allen:hash", "company", getCompanies());
//         List<Company> company = (List<Company>) hashOperations.get("java:allen:hash", "company");
//         company.stream().forEach(System.out::println);

        HashOperations<String, Object, Object> hashOperations = stringRedisTemplate.opsForHash();
        hashOperations.put("java:allen.hash2", "company", getCompanies());
        Object company = hashOperations.get("java.allen.hash2", "company");


        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        valueOperations.set("java:allen2", "test");
//        Boolean delete1 = stringRedisTemplate.delete("java:allen");
//        log.info("Delete Key2 %s", delete1);
        return (String)valueOperations.get("java:allen");
    }

    private List<Company> getCompanies() {
        ArrayList<Company> companies = new ArrayList<>();
        companies.add(new Company("apple", "US001", "csf0001"));
        companies.add(new Company("facebook", "US002", "csf0002"));
        companies.add(new Company("microsoft", "US003", "csf0003"));
        companies.add(new Company("amozon", "US004", "csf0004"));
        return companies;
    }

    private Company getCompany() {
        return new Company("amozon", "US004", "csf0004");
    }
}


//${spring.profiles.active}.${spring.application.name}.ncb.company-graph-cache.v2
//qa.kg-query-svc.ncb.company-graph-cache.v2
