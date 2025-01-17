package com.my.note.shedlockUtil.controller;

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

/**
 * Shedlock 控制器
 *
 * @Author：wangguangxing
 * @Date：2025-01-15 15:52
 * @Description：
 */
@RestController
public class ShedlockController {

    private static final long TIME_INTERVAL = 2 * 60 * 60 * 1000; //2h

    private static final String LOCK_TIME_MIN = "PT30M";
    private static final String LOCK_TIME_MAX = "PT1H";

    /**
     * 服务启动后，12000毫秒开始执行，执行频率为每两个小时
     */
    @Scheduled(initialDelay = 12000, fixedRate = TIME_INTERVAL)
    @SchedulerLock(name = "dailyTask", lockAtLeastFor = LOCK_TIME_MIN, lockAtMostFor = LOCK_TIME_MAX)
    public void dailyTask() {
        System.out.println("执行dailyTask定时任务");
    }

    /**
     * 服务启动后，12000毫秒开始执行，执行频率为每晚凌晨
     */
    @Scheduled(cron = "*/10 * * * * *")
    @SchedulerLock(name = "cycleTask", lockAtLeastFor = LOCK_TIME_MIN, lockAtMostFor = LOCK_TIME_MAX)
    public void cycleTask() {
        System.out.println("执行cycleTask定时任务");
    }
}
