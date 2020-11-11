package com.allen.domain.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author allen.jin
 * @date 2020/10/23
 */

@Mapper
public interface NlpNewsFeedMapper {

    @Select("select distinct id from nlp_news_feed limit 10")
    List<Long> getIds();
}
