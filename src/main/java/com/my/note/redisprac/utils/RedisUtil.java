package com.my.note.redisprac.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * redis工具类
 *
 * @Author：勇敢牛牛
 * @Date：2024-12-09 16:06
 * @Description：
 */
@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 将字符串放入缓存
     *
     * @param key
     * @param obj
     */
    public void set(String key, String obj) {
        redisTemplate.opsForValue().getOperations().delete(key);
        redisTemplate.opsForValue().set(key, obj);
    }

    /**
     * 将对象放入缓存
     *
     * @param key
     * @param obj
     */
    public void set(String key, Object obj) {
        redisTemplate.opsForValue().getOperations().delete(key);
        redisTemplate.opsForValue().set(key, obj);
    }

    /**
     * 根据key获取缓存里的对象
     *
     * @param key
     * @return
     */
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }


    /**
     * 获取缓存中的list
     *
     * @param key
     */
    public Object getList(String key) {
        return redisTemplate.opsForList().index(key, 0);
    }


    /**
     * 将list存入redis
     *
     * @param key
     * @param list
     */
    public void set(String key, List<?> list) {
        redisTemplate.opsForList().getOperations().delete(key);
        redisTemplate.opsForList().rightPushAll(key, list);
    }


    /**
     * 设置缓存过期时间
     *
     * @param key
     * @param list
     * @param expireTime
     */
    public void set(String key, List<?> list, long expireTime) {
        redisTemplate.opsForList().getOperations().delete(key);
        redisTemplate.opsForList().rightPushAll(key, list, expireTime, TimeUnit.MINUTES);
    }

    /**
     * 设置缓存过期时间
     *
     * @param key
     * @param obj
     * @param expireTime
     */
    public void set(String key, Object obj, long expireTime) {
        redisTemplate.opsForValue().getOperations().delete(key);
        redisTemplate.opsForValue().set(key, obj, expireTime, TimeUnit.MINUTES);
    }
}

