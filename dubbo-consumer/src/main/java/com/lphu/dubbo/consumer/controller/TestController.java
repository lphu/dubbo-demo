package com.lphu.dubbo.consumer.controller;

import com.lphu.dubbo.api.HelloService;
import com.lphu.dubbo.api.HelloService2;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hupeilei
 * @date 2022/10/17
 */
@RestController
public class TestController {

    @Autowired
    private HelloService helloService;

    @Autowired
    private HelloService2 helloService2;


    @GetMapping("/hello1")
    public String hello1() {
        return helloService.hello("message");
    }


    @GetMapping("/hello2")
    public String hello2() {
        return helloService2.hello2("message");
    }
}
