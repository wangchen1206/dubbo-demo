package com.cc.dubbo.spi.service.impl;

import com.cc.dubbo.spi.service.HelloService;
import org.apache.dubbo.common.URL;

/**
 * Description
 *
 * @author wangchen
 * @createDate 2021/07/28
 */
public class DogHelloService implements HelloService {
    @Override
    public String sayHello() {
        return "wang wang";
    }

    @Override
    public String sayHello(URL url) {
        return "wang url";
    }
}
