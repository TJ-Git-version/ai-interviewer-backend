package com.itfelix;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.itfelix.mapper")
public class AiInterviewerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AiInterviewerApplication.class);
    }
}