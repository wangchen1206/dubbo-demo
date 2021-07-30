package com.cc.learn.dubbo;

import com.cc.api.service.HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Description
 *
 * @author wangchen
 * @createDate 2021/07/27
 */
public class XmlConsumerMain {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring" +
                "/dubbo-consumer.xml");
        context.start();
        HelloService bean = context.getBean(HelloService.class);
        //控制台输入，然后程序再进行。
        int read = System.in.read();
        System.out.println("input ascii is : "+read);
        String world = bean.sayHello("world");
        System.out.println(world);

    }
}
