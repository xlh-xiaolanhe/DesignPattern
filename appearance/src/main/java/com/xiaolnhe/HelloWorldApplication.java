package com.xiaolnhe;

import com.xiaolnhe.web.HelloWorldController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 *@author: xiaolanhe
 *@createDate: 2024/3/25 23:16
 */

@SpringBootApplication
@Configuration
public class HelloWorldApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloWorldApplication.class, args);
    }
}
