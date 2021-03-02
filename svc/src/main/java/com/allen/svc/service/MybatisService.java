package com.allen.svc.service;

import com.allen.domain.entity.NewsFeed;

import java.time.LocalDate;
import java.util.List;

/**
 * @author allen.jin
 * @date 2020/10/27
 */

public interface MybatisService {
    String testMybatis();

    String evictCache();

    Integer delFeedAndContent(Long id);

    List<NewsFeed> getNewsByDate(LocalDate date);
}
