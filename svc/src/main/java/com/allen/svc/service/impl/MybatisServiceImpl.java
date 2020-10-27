package com.allen.svc.service.impl;

import com.allen.domain.dao.NlpNewsFeedMapper;
import com.allen.svc.service.MybatisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
    public String testMybatis() {
        List<Long> csfIds = nlpNewsFeedMapper.getIds();
        return csfIds.toString();
    }
}
