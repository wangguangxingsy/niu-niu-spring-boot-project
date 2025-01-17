package com.my.note.shedlockUtil.config;

import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.redis.spring.RedisLockProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Shedlock 配置
 *
 * @Author：wangguangxing
 * @Date：2025-01-15 15:49
 * @Description：
 */
@EnableScheduling
@Configuration
public class ShedlockConfig {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Bean
    public LockProvider getLockProvider() {
        return new RedisLockProvider(redisTemplate.getConnectionFactory());
    }


}
