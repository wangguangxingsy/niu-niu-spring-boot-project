package com.my.note.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.my.note.psninfodemo.dto.AgeRangeDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author：勇敢牛牛
 * @Date：2024-12-21 17:28
 * @Description：
 */
@Mapper
public interface PsnInfoMapper extends BaseMapper<AgeRangeDO> {

    /**
     * 查询年龄分布区间数据
     *
     * @return
     */
    List<AgeRangeDO> queryAgeRange();
}
