package com.cc.learn.dubbo.service.impl;

import com.cc.api.service.HelloService;
import org.apache.dubbo.config.annotation.Service;

/**
 * Description
 *
 * @author wangchen
 * @createDate 2021/07/26
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        //测试负载均衡，启动一个Main,修改一个返回结果。
        return "hello3: " + name;
    }
}
