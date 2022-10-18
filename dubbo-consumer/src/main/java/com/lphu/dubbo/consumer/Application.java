package com.lphu.dubbo.consumer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author hupeilei
 * @date 2022/10/17
 */
@SpringBootApplication
@ImportResource("classpath:dubbo-context.xml")
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
