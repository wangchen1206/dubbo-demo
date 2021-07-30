package com.cc.api.service;

/**
 * Description
 *
 * @author wangchen
 * @createDate 2021/07/27
 */
public class HelloServiceMock implements HelloService {
    @Override
    public String sayHello(String name) {
        return "hello mock";
    }
}
