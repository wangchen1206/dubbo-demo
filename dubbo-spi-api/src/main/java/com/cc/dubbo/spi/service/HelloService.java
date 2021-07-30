package com.cc.dubbo.spi.service;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

/**
 * Description
 *
 * @author wangchen
 * @createDate 2021/07/26
 */
//指定默认的具体实现
@SPI("dog")
public interface HelloService {
    String sayHello();

    @Adaptive
    String sayHello(URL url);
}
