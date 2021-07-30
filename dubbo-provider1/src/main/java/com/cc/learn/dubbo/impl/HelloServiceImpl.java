package com.cc.learn.dubbo.impl;

import com.cc.api.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Description
 *
 * @author wangchen
 * @createDate 2021/07/27
 */
public class HelloServiceImpl implements HelloService {

    public static Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Override
    public String sayHello(String name) {
        logger.info("HelloServiceImpl 被调用。。。。。。。");
        try {
            //模拟延迟，消费者mock
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello: "+name;
    }
}
