package com.cc.learn;

import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;

/**
 * Description
 *
 * @author wangchen
 * @createDate 2021/07/26
 */
public class DubboPureMain3 {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(ProviderConfiguration.class);
        annotationConfigApplicationContext.start();
        System.in.read();
    }

    @Configuration
    @EnableDubbo(scanBasePackages = "com.cc.learn.dubbo.service.impl")
    @PropertySource("classpath:/dubbo-provider3.properties")
    static class ProviderConfiguration{

        @Bean
        public RegistryConfig registryConfig(){
            RegistryConfig registryConfig = new RegistryConfig();
            registryConfig.setAddress("zookeeper://localhost:2181");
            return registryConfig;
        }
    }
}
