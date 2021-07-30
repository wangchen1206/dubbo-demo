package com.cc.dubbo.spi;

import com.cc.dubbo.spi.service.HelloService;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;

/**
 * Description
 *
 * @author wangchen
 * @createDate 2021/07/28
 */
public class AdaptiveSpiMain {
    public static void main(String[] args) {
        //动态指定 helloService具体实现， hello.service=dog，=前面的是服务接口，=后面的是META-INF/dubbo下的key
        URL url = URL.valueOf("test://localhost/hello?hello.service=human");
        HelloService helloService = ExtensionLoader.getExtensionLoader(HelloService.class).getAdaptiveExtension();
        String result = helloService.sayHello(url);
        System.out.println(helloService.getClass().getName()+": "+result);
    }
}
