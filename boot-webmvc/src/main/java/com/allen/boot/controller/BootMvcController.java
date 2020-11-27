package com.allen.boot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @date 2020/11/23
 */

@Controller
public class BootMvcController {

    @GetMapping("")
    public ResponseEntity testBootMvc() {
        return ResponseEntity.ok("Boot Mvc Success");
    }

}
