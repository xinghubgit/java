package com.allen.svc.controller;

import com.allen.svc.service.MybatisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @date 2020/10/27
 */

@RestController
@RequestMapping("/mybatis")
public class MybatisController {

    @Resource
    private MybatisService mybatisService;

    public ResponseEntity testMybatis() {
        return ResponseEntity.ok(mybatisService.testMybatis());
    }


}
