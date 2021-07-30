package com.cc.learn.dubbo;

import com.cc.learn.consumer.ConsumerComponent;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;

/**
 * Description
 *
 * @author wangchen
 * @createDate 2021/07/26
 */
public class ConsumerMain {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        context.start();
        ConsumerComponent bean = context.getBean(ConsumerComponent.class);
        while (true){
            System.in.read();
            String s = bean.sayHello("CC");
            System.out.println("result: "+s);
        }
    }

    @EnableDubbo
    @ComponentScan("com.cc.learn.consumer")
    @Configuration
    @PropertySource("classpath:/dubbo-consumer.properties")
    static class ConsumerConfiguration{}
}
