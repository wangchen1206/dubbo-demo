package com.cc.learn;

import com.cc.learn.dubbo.SayHelloService;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Description
 *
 * @author wangchen
 * @createDate 2021/08/02
 */
public class ConsumerMain {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/dubbo-consumer.xml");
        SayHelloService sayHelloService = context.getBean(SayHelloService.class);
        for (int i = 0; i < 1010; i++) {
            Thread.sleep(200);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String cc = sayHelloService.sayHello("CC", 1000);
                    System.out.println("result: " + cc);
                }
            }).start();
        }
    }
}
