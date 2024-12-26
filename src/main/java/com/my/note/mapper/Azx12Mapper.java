package com.my.note.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.my.note.areacodedemo.entity.Azx12;
import com.my.note.psninfodemo.dto.AgeRangeDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 行政区划树表Mapper 接口
 *
 * @Author：wangguangxing
 * @Date：2024-12-19 15:22
 * @Description：
 */
@Mapper
public interface Azx12Mapper extends BaseMapper<Azx12> {

    List<Azx12> selectAll();

    /**
     * 查询年龄分布区间数据
     *
     * @return
     */
    List<AgeRangeDO> queryAgeRange();
}
