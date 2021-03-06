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
        while (true){
            System.in.read();
            String cc = sayHelloService.sayHello("CC", 3000);
            System.out.println("result: "+cc);
            //异步调用
//            Future<Object> future = RpcContext.getContext().getFuture();
//            System.out.println("future result: "+future.get());
        }
    }
}
