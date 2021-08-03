package com.cc.learn.dubbo;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.threadpool.support.fixed.FixedThreadPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.*;

/**
 * dubbo自定义线程池
 *
 * @author wangchen
 * @createDate 2021/08/03
 */
public class WatchingThreadPool extends FixedThreadPool implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(WatchingThreadPool.class);

    //设置阈值
    private static final double ALARM_PERCENT = 0.90;
    //设置线程池map
    private final Map<URL, ThreadPoolExecutor> THREAD_POOLS = new ConcurrentHashMap<>();

    //每3s打印线程使用情况
    public WatchingThreadPool() {
        Executors.newSingleThreadScheduledExecutor()
                .scheduleWithFixedDelay(this, 1000, 600, TimeUnit.MILLISECONDS);
    }

    @Override
    public Executor getExecutor(URL url) {
        //从父类中创建线程池
        final Executor executor = super.getExecutor(url);
        if (executor instanceof ThreadPoolExecutor) {
            THREAD_POOLS.put(url, (ThreadPoolExecutor) executor);
        }
        return executor;
    }

    /**
     * 监控
     *
     * @author wangchen
     * @createDate 2021/8/3
     **/
    @Override
    public void run() {
        THREAD_POOLS.entrySet().forEach(e -> {
            final URL url = e.getKey();
            final ThreadPoolExecutor executor = e.getValue();

            //当前执行中的线程数
            int activeCount = executor.getActiveCount();
            //总计线程数
            int corePoolSize = executor.getCorePoolSize();

            double used = activeCount / corePoolSize;
            final int useNum = (int) used * 100;
            LOGGER.info("线程池执行状态：[{}/{}:{}%]", activeCount, corePoolSize, useNum);

            if (used > ALARM_PERCENT) {
                LOGGER.error("超出警戒值！ host:{}，当前已使用量：{}%，URL:{}", url.getIp(), useNum, url);
            }
        });
    }
}
