package com.my.note.redisdemo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author：wangguangxing
 * @Date：2025-01-10 16:07
 * @Description：
 */
@Component
public class RedisLockUtil {


    // 锁的前缀，用于区分不同的锁
    private static final String LOCK_PREFIX = "lock:";

    // Lua 脚本用于释放锁
    private static final String UNLOCK_SCRIPT =
            "if redis.call('GET', KEYS[1]) == ARGV[1] then return redis.call('DEL', KEYS[1]) else return 0 end";

    // Lua 脚本用于续期锁
    private static final String RENEW_LOCK_SCRIPT =
            "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('pexpire', KEYS[1], ARGV[2]) else return 0 end";

    // 续期锁的时间间隔（毫秒）
    private static final long RENEW_INTERVAL_MS = 10000;

    // 锁的默认过期时间（毫秒）
    private static final long DEFAULT_EXPIRE_TIME_MS = 7000;

    //最大重试次数
    private static final int MAX_RETRIES = 3;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 尝试获取锁
     *
     * @param lockKey 锁的键名
     * @return
     */
    public String tryLock(String lockKey) {
        String lockValue = UUID.randomUUID().toString();
        //setIfAbsent实现上锁
        Boolean result = redisTemplate.opsForValue().setIfAbsent(LOCK_PREFIX + lockKey, lockValue);
        if (null != result && result) {
            //设置锁过期时间
            redisTemplate.expire(LOCK_PREFIX + lockKey, DEFAULT_EXPIRE_TIME_MS, TimeUnit.MILLISECONDS);
            return lockValue;
        }
        return null;
    }

    /**
     * 自动续期
     *
     * @param lockKey   锁的键名
     * @param lockValue 锁的值（用于验证是否是持有锁的客户端）
     */
    public void autoRenewalLock(String lockKey, String lockValue) {
        System.out.println("续期锁名：" + LOCK_PREFIX + lockKey + "续期锁值：" + lockValue);
        Thread thread = new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(2000);

                    Boolean result = redisTemplate.expire(LOCK_PREFIX + lockKey, RENEW_INTERVAL_MS, TimeUnit.MILLISECONDS);
                    System.out.println("续期结果result:" + result);
                    if (result) {  // 续锁操作
                        System.out.println("自动续期成功！" + "当前锁为：" + redisTemplate.opsForValue().get(LOCK_PREFIX + lockKey));
                    } else {
                        System.out.println("自动续期失败！（主线程任务已执行完毕）" + "当前锁为：" + redisTemplate.opsForValue().get(LOCK_PREFIX + lockKey));
                        // 如果续期失败，直接结束守护线程，停止锁续期行为。
                        // 这里说明下，删除锁和续锁都需要验证lockValue，这个上锁时通过uuid创建的，其他线程肯定获取的都不一致，这样确保续锁行为只能是自己的守护线程才可以操作；如果续锁失败了，则说明是主线程完成任务删除了key锁，所以这里守护线程也可以结束了
                        break;
                    }

                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    /**
     * 乐观锁
     *
     * @param lockKey   锁的键名
     * @param lockValue 锁的值
     */
    public void autoRenwalWatchLock(String lockKey, String lockValue) {
        int retries = 0;
        while (retries < MAX_RETRIES) {
            redisTemplate.watch(LOCK_PREFIX + lockKey);
            ValueOperations<String, Object> valueOps = redisTemplate.opsForValue();
            String currentValue = (String) valueOps.get(LOCK_PREFIX + lockKey);
            if (null != currentValue && currentValue.equals(lockValue)) {
                try {
                    //开启事务
                    redisTemplate.multi();
                    redisTemplate.expire(LOCK_PREFIX + lockKey, RENEW_INTERVAL_MS, TimeUnit.MILLISECONDS);
                    //执行事务中的操作
                    redisTemplate.exec();
                    System.out.println("第" + retries + "次续期成功。");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    // 处理异常
                    redisTemplate.discard();
                    System.out.println(e.getMessage());
                }

            } else {
                redisTemplate.unwatch();
            }
            retries++;
        }
    }

    /**
     * 释放锁
     *
     * @param lockKey   锁的键
     * @param lockValue 锁的值
     * @return
     */
    public boolean unlock(String lockKey, String lockValue) {
        DefaultRedisScript<Long> script = new DefaultRedisScript<>(UNLOCK_SCRIPT, Long.class);
        // 执行lua脚本，参数解释下：
        // 第一个参数script为lua脚本
        // 第二个参数为key的集合，会依次替换lua脚本中的KEYS[]数组的数据，默认1开始
        // 第三个参数为参数集合，会依次替换lua脚本中的ARGVS[]数组的数据，默认1开始
        Long result = redisTemplate.execute(script, Collections.singletonList(LOCK_PREFIX + lockKey), lockValue);
        return result != null && result == 1L;
    }

    /**
     * 获取剩余过期时间
     *
     * @param lockKey
     * @return
     */
    public Long getExpire(String lockKey) {
        return redisTemplate.getExpire(LOCK_PREFIX + lockKey);
    }
}
