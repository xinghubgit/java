package com.allen.svc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @date 2020/10/23
 */

@RestController
@RequestMapping("/allen")
public class AllenController {

    @GetMapping
    public ResponseEntity test() {
        return ResponseEntity.ok("");
    }

}
