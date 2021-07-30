package com.cc.learn.dubbo.spi.loadbalance;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.RpcException;
import org.apache.dubbo.rpc.cluster.LoadBalance;

import java.util.List;

/**
 * Description
 *
 * @author wangchen
 * @createDate 2021/07/30
 */
public class OnlyFirstLoadBalancer implements LoadBalance {
    @Override
    public <T> Invoker<T> select(List<Invoker<T>> invokers, URL url, Invocation invocation) throws RpcException {
        //选择ip+端口 字母排序
        return invokers.stream().sorted((i1,i2)->{
            final int compare = i1.getUrl().getIp().compareTo(i2.getUrl().getIp());
            if (compare == 0){
                return Integer.compare(i1.getUrl().getPort(),i2.getUrl().getPort());
            }
            return compare;
        }).findFirst().get();
    }
}
