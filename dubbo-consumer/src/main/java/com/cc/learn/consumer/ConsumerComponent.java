package com.cc.learn.consumer;

import com.cc.api.service.HelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

/**
 * Description
 *
 * @author wangchen
 * @createDate 2021/07/26
 */
@Component
public class ConsumerComponent {

    //配置负载均衡策略，也可以再provider方配置，xml配置可以配置到方法级别。
    @Reference(loadbalance = "onlyFirst")
    private HelloService helloService;

    public String sayHello(String name){
        return helloService.sayHello(name);
    }
}
