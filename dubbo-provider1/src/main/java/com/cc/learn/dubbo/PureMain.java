package com.cc.learn.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Description
 *
 * @author wangchen
 * @createDate 2021/07/27
 */
public class PureMain {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/dubbo-*.xml");
        context.start();
        System.in.read();

    }
}
