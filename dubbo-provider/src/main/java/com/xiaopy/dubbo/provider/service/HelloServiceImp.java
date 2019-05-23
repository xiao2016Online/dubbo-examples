package com.xiaopy.dubbo.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaopy.dubbo.api.service.HelloService;
import lombok.extern.slf4j.Slf4j;

@Service(version = "${demo.service.version}")
@Slf4j
public class HelloServiceImp implements HelloService {
    @Override
    public String sayHelloWorld(String name) {
        log.info("参数={}",name);
        return "welcome to dubbo , "+name;
    }
}
