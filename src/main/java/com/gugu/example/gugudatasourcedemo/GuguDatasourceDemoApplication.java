package com.gugu.example.gugudatasourcedemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@MapperScan("com.gugu.example.gugudatasourcedemo.mapper")
public class GuguDatasourceDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuguDatasourceDemoApplication.class, args);
    }

}
