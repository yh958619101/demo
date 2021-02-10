package com.yh.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yh
 * @version 1.0
 * @date 2020/6/13 0013 19:15
 */
@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) {
        //启动springboot项目，需要传入一个有@SpringBootApplication注解修饰的类对象
        SpringApplication.run(TestApplication.class, args);

    }
}
