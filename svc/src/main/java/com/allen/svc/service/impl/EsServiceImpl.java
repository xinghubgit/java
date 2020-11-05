package com.allen.svc.service.impl;

import com.allen.svc.service.EsService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @date 2020/10/29
 */

@Slf4j
@Service
public class EsServiceImpl implements EsService {

    @Resource
    private ElasticsearchRestTemplate esRestTemplate;

    @Resource
    private RestHighLevelClient restClient;

    @Override
    public String testEs() {
        RestHighLevelClient client = esRestTemplate.getClient();
        log.info(client.toString());

        QueryBuilder queryBuilder = new TermQueryBuilder("newsSentiment", 2);
        SearchQuery query = new NativeSearchQueryBuilder().withQuery(queryBuilder).build();
        query.addIndices("analysis_news_v1");
        long count = esRestTemplate.count(query);

        return String.valueOf(count);
    }
}
