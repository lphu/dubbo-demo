package com.lphu.dubbo.provider.service;

import com.lphu.dubbo.api.HelloService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;


/**
 * @author hupeilei
 * @date 2022/10/17
 */
@Component
@DubboService(interfaceClass = HelloService.class, version = "1.0.0")
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String message) {
        System.out.println("received " + message);
        return "reply " + message;
    }
}
