package com.camelot.pmt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author daiyang
 * @date 2018/5/4
 */
@SpringBootApplication
@MapperScan("com.camelot.pmt.mapper")
public class PmtApplication {

    public static void main(String[] args) {
        SpringApplication.run(PmtApplication.class, args);
    }
}
