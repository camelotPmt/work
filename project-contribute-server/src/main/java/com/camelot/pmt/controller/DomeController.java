package com.camelot.pmt.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by daiyang on 2018/5/4.
 */
@RestController
@RequestMapping("/demo")
public class DomeController {

    @GetMapping("/zhangao")
    public ResponseEntity dome() {
        return ResponseEntity.ok("请求成功");
    }


    private static final Logger LOGGER = LogManager.getLogger(DomeController.class);

}