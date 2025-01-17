package com.my.note.threaddemo.controller;

import com.my.note.areacodedemo.dto.AreaCodeResDTO;
import com.my.note.areacodedemo.entity.Azx12;
import com.my.note.areacodedemo.utils.AreaCodeUtil;
import com.my.note.threaddemo.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 多线程 控制器
 *
 * @Author：wangguangxing
 * @Date：2025-01-03 15:31
 * @Description：
 */
@RestController
@RequestMapping("/thread")
public class ThreadController {

    @Autowired
    private ThreadService threadService;

    @Autowired
    private AreaCodeUtil areaCodeUtil;

    //设置每个线程一次查询的条数
    private static final int LIMIT = 100;

    /**
     * 多线程查询
     *
     * @return
     */
    @PostMapping("/queryAreaByThread")
    public List<AreaCodeResDTO> queryAreaByThread() throws ExecutionException, InterruptedException {
        Long s = System.currentTimeMillis();
        //假设总数量为210条
        int total = 2100;
        //计算需要分几轮查询
        int num = total % LIMIT == 0 ? total / LIMIT : total / LIMIT + 1;
        //接收线程返回结果
        List<Future<List<AreaCodeResDTO>>> futureList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            int pageNum = i;
            int pageSize = LIMIT;
            Future<List<AreaCodeResDTO>> future = threadService.queryAreaByThread(pageNum, pageSize);
            futureList.add(future);
        }
        List<AreaCodeResDTO> resultList = new ArrayList<>();
        //异步处理多线程返回结果
        while (!futureList.isEmpty()) {
            Iterator<Future<List<AreaCodeResDTO>>> iterator = futureList.iterator();
            while (iterator.hasNext()) {
                Future<List<AreaCodeResDTO>> next = iterator.next();
                if (next.isDone()) {
                    List<AreaCodeResDTO> item = next.get();
                    resultList.addAll(item);
                    //避免一直循环导致内存溢出
                    iterator.remove();
                }
            }
        }
        Long e = System.currentTimeMillis();
        System.out.println("使用多线程查询耗时(秒):" + (e - s) / 1000);
        return resultList;
    }

    /**
     * 不使用多线程
     *
     * @return
     */
    @PostMapping("/queryArea")
    public List<AreaCodeResDTO> queryArea() throws ExecutionException, InterruptedException {
        Long s = System.currentTimeMillis();
        //假设总数量为210条
        int total = 2100;
        //计算需要分几轮查询
        int num = total % LIMIT == 0 ? total / LIMIT : total / LIMIT + 1;
        List<AreaCodeResDTO> resultList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            int pageNum = i;
            int pageSize = LIMIT;
            List<AreaCodeResDTO> list = threadService.queryArea(pageNum, pageSize);
            resultList.addAll(list);
        }
        Long e = System.currentTimeMillis();
        System.out.println("不使用多线程耗时(秒):" + (e - s) / 1000);
        return resultList;
    }

    /**
     * 使用多线程推送数据，不返回结果
     */
    @PostMapping("/pushDate")
    public void pushDate() {
        //待推送数据
        List<Azx12> azx12List = areaCodeUtil.parseAreasBackByLevel(3);
        if (!azx12List.isEmpty()) {
            int total = azx12List.size();
            //计算需要的线程数
            int num = total % LIMIT == 0 ? total / LIMIT : total / LIMIT + 1;
            for (int i = 0; i < num; i++) {
                int start = i * LIMIT;
                int end = total < (i + 1) * LIMIT ? total : (i + 1) * LIMIT;
                threadService.pushData(azx12List, start, end);
            }
        }
    }
}
