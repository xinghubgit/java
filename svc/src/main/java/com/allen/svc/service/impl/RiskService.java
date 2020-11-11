package com.allen.svc.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @date 2020/11/10
 */

@Service
public class RiskService {

    @Resource
    private RestTemplate restTemplate;


    private String newsQueryUrl;

    private String newsStatUrl;

    private String kgQueryUrl;

}
