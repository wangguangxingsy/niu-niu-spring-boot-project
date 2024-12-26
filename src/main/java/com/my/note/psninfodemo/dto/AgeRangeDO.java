package com.my.note.psninfodemo.dto;

import lombok.Data;

/**
 * 年龄分布区间数据  出参
 *
 * @Author：勇敢牛牛
 * @Date：2024-10-22 15:48
 * @Description：
 */
@Data
public class AgeRangeDO {

    //分布区间 例如：20岁以下  20 - 30岁
    private String axis;

    //男性数量
    private int manValue;

    //女性数量
    private int womenValue;

}
