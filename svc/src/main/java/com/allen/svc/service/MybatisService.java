package com.allen.svc.service;

import org.springframework.cache.annotation.CacheEvict;

/**
 * @author allen.jin
 * @date 2020/10/27
 */

public interface MybatisService {
    String testMybatis();

    String evictCache();
}
