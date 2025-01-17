package com.my.note.redisdemo.controller;

import com.my.note.areacodedemo.dto.AreaCodeResDTO;
import com.my.note.areacodedemo.entity.Azx12;
import com.my.note.areacodedemo.utils.AreaCodeUtil;
import com.my.note.common.CommonResponse;
import com.my.note.redisdemo.utils.RedisLockUtil;
import com.my.note.redisdemo.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.task.TaskExecutor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * redis使用
 *
 * @Author：勇敢牛牛
 * @Date：2024-12-09 10:36
 * @Description：
 */
@RestController
@RequestMapping("/redisPrac")
public class RedisPracController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Value("${note.redis.namespace}" + ":AREA_KEY_PREFIX_")
    private String AREA_KEY_PREFIX;

    @Value("${note.redis.namespace}" + ":AREA_LIST_KEY_PREFIX")
    private String AREA_LIST_KEY_PREFIX;

    @Autowired
    private AreaCodeUtil areaCodeUtil;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private RedisLockUtil redisLockUtil;

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    /**
     * redis分布锁
     */
    @PostMapping("/redisLockTest")
    public void redisLockTest() {
        //锁的键名
        String lockKey = "test_lock_key";
        for (int i = 0; i < 5; i++) {
            //启动多个线程来尝试获取锁
            taskExecutor.submit(() -> {
                //尝试获取锁
                String lockValue = redisLockUtil.tryLock(lockKey);
                if (null != lockValue) {
                    System.out.println(Thread.currentThread().getName() + "已获取到锁，并开始执行任务");
                    //开启自动续期，避免任务还未执行完，但锁已过期
                    redisLockUtil.autoRenewalLock(lockKey, lockValue);
                    try {
                        //开始执行任务，且时间超过过期时间
                        Thread.sleep(10000);
                        System.out.println(Thread.currentThread().getName() + "任务执行完成，此时锁的剩余过期时间为：" + redisLockUtil.getExpire(lockKey));

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        boolean unlock = redisLockUtil.unlock(lockKey, lockValue);
                        if (unlock) {
                            System.out.println(Thread.currentThread().getName() + " 成功释放锁");
                        } else {
                            System.out.println(Thread.currentThread().getName() + " 释放锁失败，锁已过期！。");
                        }
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + "未能获取到锁");
                }
            });
        }
    }

    /**
     * 从缓存获取区划代码-对象
     *
     * @param level
     * @return
     */
    @GetMapping("/getAreaFromRedis")
    public CommonResponse<?> getAreaFromRedis(int level) {
        String key = AREA_KEY_PREFIX + level;
        Object obj = redisUtil.get(key);
        return CommonResponse.success(obj);
    }

    /**
     * 从缓存获取区划代码-list（根据level获取，相当于根据level查询）
     *
     * @param level
     * @return
     */
    @GetMapping("/getAreaListFromRedis")
    public CommonResponse<?> getAreaListFromRedis(int level) {
        String key = AREA_LIST_KEY_PREFIX + level;
        Object obj = redisUtil.getList(key);
        return CommonResponse.success(obj);
    }

    /**
     * 获取全国区划代码并存入缓存中
     *
     * @return
     */
    public void areaCodeListToRedis() {
        for (int level = 1; level < 6; level++) {
            String key = AREA_LIST_KEY_PREFIX + level;
            List<Azx12> azx12List = areaCodeUtil.parseAreasBackByLevel(level);
            //value:list
            redisUtil.set(key, azx12List);
        }
    }

    /**
     * 获取全国区划代码并存入缓存中
     *
     * @return
     */
    public void areaCodeToRedis() {
        for (int level = 1; level < 6; level++) {
            String key = AREA_KEY_PREFIX + level;
            AreaCodeResDTO resDTO = areaCodeUtil.parseAreasFrontByLevel(level);
            //value:对象
            redisUtil.set(key, resDTO);
        }
    }


}
