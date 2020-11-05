package com.allen.svc.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

import javax.annotation.Resource;

/**
 * @date 2020/10/29
 */

@Configuration
public class EsConfig {

    @Resource
    private RestHighLevelClient client;

    @Resource
    private ElasticsearchRestTemplate esRestTemplate;




}
