package com.cc.dubbo.spi;

import com.cc.dubbo.spi.service.HelloService;
import org.apache.dubbo.common.extension.ExtensionLoader;

import java.util.Set;

/**
 * 1. JDK 标准的 SPI 会一次性实例化扩展点所有实现，如果有扩展实现初始化很耗时，但如果没用上也加
 * 载，会很浪费资源
 * 2. 如果有扩展点加载失败，则所有扩展点无法使用
 * 3. 提供了对扩展点包装的功能(Adaptive)，并且还支持通过set的方式对其他的扩展点进行注入
 *  *
 * @author wangchen
 * @createDate 2021/07/28
 */
public class SpiMain {
    public static void main(String[] args) {
        //获取扩展加载器
        ExtensionLoader<HelloService> extensionLoader = ExtensionLoader.getExtensionLoader(HelloService.class);
        //遍历所有的支持的扩展点，META-INF/dubbo
        Set<String> supportedExtensions = extensionLoader.getSupportedExtensions();
        supportedExtensions.forEach(e->{
            String result = extensionLoader.getExtension(e).sayHello();
            System.out.println(result);
        });
    }
}
