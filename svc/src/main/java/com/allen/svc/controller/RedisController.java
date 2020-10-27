package com.allen.svc.controller;

import com.allen.svc.service.RedisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @date 2020/10/26
 */

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Resource
    private RedisService redisService;

    @GetMapping
    public ResponseEntity testRedis() {
        return ResponseEntity.ok(redisService.testRedis());
    }

}
