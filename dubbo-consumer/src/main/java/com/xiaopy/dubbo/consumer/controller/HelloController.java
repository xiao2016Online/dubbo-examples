package com.xiaopy.dubbo.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xiaopy.dubbo.api.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Reference(version = "${demo.service.version}")
    private HelloService helloService;

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable("name") String name) {
        return helloService.sayHelloWorld(name);
    }
}
