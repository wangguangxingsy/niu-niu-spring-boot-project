package com.my.note.threaddemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池配置
 *
 * @Author：wangguangxing
 * @Date：2025-01-03 14:58
 * @Description：
 */
@Configuration
@EnableAsync
public class ThreadPoolConfig {

    //设置核心线程数等于系统核数
    private static final int CODE_POOL_SIZE = Runtime.getRuntime().availableProcessors();
    //最大线程数
    private static final int MAX_POOL_SIZE = CODE_POOL_SIZE * 2;
    //允许线程空闲时间（单位：默认秒）
    private static final int KEEP_ALIVE_TIME = 10;
    //缓冲队列数
    private static final int QUEUE_CAPACITY = MAX_POOL_SIZE;
    //线程池名称前缀
    private static final String THREAD_NAME_PREFIX = "execurot-";

    @Bean("taskExecutor")
    public ThreadPoolTaskExecutor getTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(CODE_POOL_SIZE);
        executor.setMaxPoolSize(MAX_POOL_SIZE);
        executor.setKeepAliveSeconds(KEEP_ALIVE_TIME);
        executor.setQueueCapacity(QUEUE_CAPACITY);
        executor.setThreadNamePrefix(THREAD_NAME_PREFIX);
        //就算线程池任务被丢弃，也不应该影响业务接口，可以使用DiscardPolicy策略直接丢弃
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        //等待所有任务结束后在关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.initialize();
        return executor;
    }


}
