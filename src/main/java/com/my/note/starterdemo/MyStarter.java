package com.my.note.starterdemo;

import com.my.note.redisdemo.controller.RedisPracController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 服务启动后，执行的初始化操作
 *
 * @Author：勇敢牛牛
 * @Date：2024-12-09 10:18
 * @Description：
 */
@Component
public class MyStarter implements CommandLineRunner {

    @Autowired
    private RedisPracController redisPracController;

    @Override
    public void run(String... args) throws Exception {
//        redisPracController.areaCodeToRedis();
//        redisPracController.areaCodeListToRedis();
        System.out.println("行政区划缓存加载完成！");
    }
}
