package com.allen.svc.controller;

import com.allen.svc.config.LocalDateEditor;
import com.allen.svc.service.MybatisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDate;

/**
 * @date 2020/10/27
 */

@RestController
@RequestMapping("/mybatis")
public class MybatisController {

    @Resource
    private MybatisService mybatisService;

    @GetMapping
    public ResponseEntity testMybatis() {
        return ResponseEntity.ok(mybatisService.testMybatis());
    }

    @GetMapping("/evict")
    public ResponseEntity evictCache() {
        return ResponseEntity.ok(mybatisService.evictCache());
    }

    @GetMapping("/{id}")
    public ResponseEntity deleteNewsId(@PathVariable Long id) {
        return ResponseEntity.ok(mybatisService.delFeedAndContent(id));
    }

    @GetMapping("/news")
    public ResponseEntity getNewsByDate(@RequestParam LocalDate date) {
        return ResponseEntity.ok(mybatisService.getNewsByDate(date));
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(LocalDate.class, new LocalDateEditor());
    }
}
