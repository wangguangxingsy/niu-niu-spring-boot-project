package com.my.note.area.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 行政区划树表（系统用）
 * </p>
 *
 * @author 勇敢牛牛
 * @since 2024-11-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Azx12 implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 行政区划代码
     */
    @TableId("ID")
    private String id;

    /**
     * 父节点ID
     */
    @TableField("PARENTID")
    private String parentid;

    /**
     * 行政区划名称
     */
    @TableField("LABEL")
    private String label;

    /**
     * 行政区划全称
     */
    @TableField("FULLLABEL")
    private String fulllabel;

    /**
     * 是否叶子节点
     */
    @TableField("ISLEAF")
    private String isleaf;

    /**
     * 拼音码
     */
    @TableField("SPELL")
    private String spell;

    /**
     * 是否常用
     */
    @TableField("ISCOMMON")
    private String iscommon;

    /**
     * 排列顺序
     */
    @TableField("ORDNUMBER")
    private String ordnumber;

    /**
     * 层级
     */
    @TableField("FLOOR")
    private String floor;

    /**
     * 国家标准行政区划代码
     */
    @TableField("STATEID")
    private String stateid;

    /**
     * 国家标准行政区划名称
     */
    @TableField("STATELABEL")
    private String statelabel;


}
