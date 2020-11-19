package com.allen.svc.service.impl;

import com.allen.domain.dao.NlpNewsFeedMapper;
import com.allen.svc.service.MybatisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @date 2020/10/27
 */

@Slf4j
@Service
public class MybatisServiceImpl implements MybatisService {

    @Resource
    private NlpNewsFeedMapper nlpNewsFeedMapper;

    @Override
    @Cacheable(cacheNames = "mybatis2", keyGenerator = "riskKeyGenerator")
    public String testMybatis() {
        log.info("Get Data From Mapper");
        List<Long> csfIds = nlpNewsFeedMapper.getIds();
        return csfIds.toString();
    }

    @Override
    @CacheEvict(cacheNames = "mybatis8")
    public String evictCache() {
        return "success";
    }

    @Override
    @Transactional
    public Integer delFeedAndContent(Long id) {
        Integer feedNum = nlpNewsFeedMapper.deleteFeedById(id);
        Integer contentNum = nlpNewsFeedMapper.deleteContentById(id);
//        Integer eventNum = nlpNewsFeedMapper.deleteEventById(id);

        return feedNum + contentNum;
    }
}
