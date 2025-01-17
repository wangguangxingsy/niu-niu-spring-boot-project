package com.my.note.threaddemo.service;

import com.my.note.areacodedemo.dto.AreaCodeResDTO;
import com.my.note.areacodedemo.entity.Azx12;

import java.util.List;
import java.util.concurrent.Future;

/**
 * 多线程 服务类
 *
 * @Author：wangguangxing
 * @Date：2025-01-03 14:56
 * @Description：
 */
public interface ThreadService {

    /**
     * 使用多线程查询
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    Future<List<AreaCodeResDTO>> queryAreaByThread(int pageNum, int pageSize);

    /**
     * 不使用多线程
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<AreaCodeResDTO> queryArea(int pageNum, int pageSize);

    /**
     * 推送到数据库
     *
     * @param
     */
    void pushData(List<Azx12> list, int start, int end);
}
