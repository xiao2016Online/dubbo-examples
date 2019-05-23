# Duddo Demo 

## 架构
该demo项目采用maven搭建，使用springboot+dubbo+zookeeper
本项目分成三个模块，三个模块的功能：
- dubbo-api 服务提供者的接口
- dubbo-provider 服务提供者
- dubbo-consumer	服务消费者

## 说明
本项目中的zookeeper 我采用docker的方式，在自己的云服务器上构建

### 1 dubbo-api
抽象服务提供者的接口供服务消费者调用
```
public interface HelloService {
    String sayHelloWorld(String name);
}
```
### 2 dubbo-provider

```
@Service(version = "${demo.service.version}")
@Slf4j
public class HelloServiceImp implements HelloService {
    @Override
    public String sayHelloWorld(String name) {
        log.info("参数={}",name);
        return "welcome to dubbo , "+name;
    }
}
```
注意：Service 不是Spring 中的service
import com.alibaba.dubbo.config.annotation.Service;

### 3 dubbo-consumer 

```
@RestController
public class HelloController {

    @Reference(version = "${demo.service.version}")
    private HelloService helloService;

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable("name") String name) {
        return helloService.sayHelloWorld(name);
    }
}

```

注意：在privider 以及consumer启动类上加注解，如下所示
```
@SpringBootApplication
@EnableDubbo
public class DubboConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerApplication.class, args);
    }

}
```
