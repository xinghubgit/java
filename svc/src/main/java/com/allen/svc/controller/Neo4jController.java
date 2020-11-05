package com.allen.svc.controller;

import com.allen.svc.service.Neo4jService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @date 2020/11/5
 */

@RestController
@RequestMapping
public class Neo4jController {

    @Resource
    private Neo4jService neo4jService;

    @GetMapping
    public ResponseEntity testNeo4j() {
        return ResponseEntity.ok(neo4jService.testNeo4j());
    }
}

