package com.allen.domain.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author allen.jin
 * @date 2020/10/23
 */

@Mapper
public interface NlpNewsFeedMapper {

    List<Long> getIds();
}
