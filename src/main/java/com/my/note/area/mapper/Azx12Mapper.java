package com.my.note.area.mapper;

import com.my.note.area.entity.Azx12;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 行政区划树表（系统用） Mapper 接口
 * </p>
 *
 * @author 勇敢牛牛
 * @since 2024-11-30
 */
@Mapper
public interface Azx12Mapper extends BaseMapper<Azx12> {

    List<Azx12> selectAll();

}
