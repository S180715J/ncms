package com.newer.ncms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.newer.**.mapper")
public class NcmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NcmsApplication.class, args);
	}

}
