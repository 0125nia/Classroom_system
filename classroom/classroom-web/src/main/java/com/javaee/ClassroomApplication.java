package com.javaee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author nia
 * @description 启动类
 * @Date 2024/6/10
 */
@SpringBootApplication
@EnableWebMvc
public class ClassroomApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClassroomApplication.class,args);
    }

}
