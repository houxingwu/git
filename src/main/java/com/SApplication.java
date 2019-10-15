package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description 启动类
 * @Author
 * @Date 2019-09-27 11:07
 * @Version 1.0
 */
@SpringBootApplication
@EnableSwagger2
public class SApplication {
    public static void main(String[] args) {
        SpringApplication.run(SApplication.class, args);
    }
}
