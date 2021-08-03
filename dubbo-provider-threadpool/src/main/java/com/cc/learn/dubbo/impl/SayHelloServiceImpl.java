package com.cc.learn.dubbo.impl;

import com.cc.learn.dubbo.SayHelloService;

/**
 * Description
 *
 * @author wangchen
 * @createDate 2021/08/02
 */
public class SayHelloServiceImpl implements SayHelloService {
    @Override
    public String sayHello(String name, int timeOut) {
        try {
            Thread.sleep(timeOut);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello: " + name;
    }
}
