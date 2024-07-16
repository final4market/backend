package com._market.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com._market.demo.mapper")
public class Final4marketApplication {

    public static void main(String[] args) {
        SpringApplication.run(Final4marketApplication.class, args);
    }

}
