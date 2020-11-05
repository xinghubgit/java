package com.allen.svc.controller;

import com.allen.svc.service.EsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @date 2020/10/29
 */

@RestController
@RequestMapping("/es")
public class EsController {

    @Resource
    private EsService esService;

    @GetMapping
    public ResponseEntity testEs() {
        return ResponseEntity.ok(esService.testEs());
    }
}
