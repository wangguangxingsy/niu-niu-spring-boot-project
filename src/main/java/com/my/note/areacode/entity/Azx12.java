package com.my.note.areacode.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;
import java.util.List;

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
    private String value;

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
     * 子节点
     */
    @TableField(exist = false)
    private List<Azx12> children;

    /**
     * 层级
     */
    @TableField(exist = false)
    private int level;


}
