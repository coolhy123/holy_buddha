package com.hydu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author heyong
 * @Date: 2020/6/4  22:50
 */
@SpringBootApplication
@MapperScan("com.hydu.mapper")
public class AppApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class);
    }
}
