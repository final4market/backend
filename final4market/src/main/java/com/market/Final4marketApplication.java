package com.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;



@SpringBootApplication
@MapperScan({"com.market.dao", "com.market.mapper"})  
public class Final4marketApplication {

	public static void main(String[] args) {
		SpringApplication.run(Final4marketApplication.class, args);
	}

}
