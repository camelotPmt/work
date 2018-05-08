package com.camelot.pmt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by daiyang on 2018/5/4.
 *
 */
@RestController
@RequestMapping("/demo")
public class DomeController {

    @GetMapping("/zhangao")
    public ResponseEntity dome(){
        return ResponseEntity.ok("请求成功");
    }
}
