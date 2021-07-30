package com.cc.learn.dubbo.filter;

import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;

/**
 * dubbo自定义过滤器，依靠dubbo的spi机制实现
 *
 * 使用org.apache.dubbo.common.extension.Activate 接口进行对类进行注册 通过group 可以指定生产端 消费端
 * 在META-INF.dubbo 中新建org.apache.dubbo.rpc.Filter 文件，并将当前类的全名写入
 * 一般类似于这样的功能都是单独开发依赖的，所以再使用方的项目中只需要引入依赖，在调用接口时，该方法便会自动拦截。
 *
 * @author wangchen
 * @createDate 2021/07/30
 */
@Activate(group = {CommonConstants.CONSUMER,CommonConstants.PROVIDER_SIDE})
public class InvokeTimeFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        long startTime = System.currentTimeMillis();
        Result res = invoker.invoke(invocation);
        System.out.println("invoke time : "+(System.currentTimeMillis() - startTime)+"ms");
        return res;
    }
}
