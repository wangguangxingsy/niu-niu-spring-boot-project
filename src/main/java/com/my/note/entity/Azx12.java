package com.my.note.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class Azx12 implements Serializable {
    @ApiModelProperty(value = "行政区划代码")
    private String id;

    @ApiModelProperty(value = "父节点ID")
    private String parentid;

    @ApiModelProperty(value = "行政区划名称")
    private String label;

    @ApiModelProperty(value = "行政区划全称")
    private String fulllabel;

    @ApiModelProperty(value = "是否叶子节点")
    private String isleaf;

    @ApiModelProperty(value = "拼音码")
    private String spell;

    @ApiModelProperty(value = "是否常用")
    private String iscommon;

    @ApiModelProperty(value = "排列顺序")
    private String ordnumber;

    @ApiModelProperty(value = "层级")
    private String floor;

    @ApiModelProperty(value = "国家标准行政区划代码")
    private String stateid;

    @ApiModelProperty(value = "国家标准行政区划名称")
    private String statelabel;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getFulllabel() {
        return fulllabel;
    }

    public void setFulllabel(String fulllabel) {
        this.fulllabel = fulllabel;
    }

    public String getIsleaf() {
        return isleaf;
    }

    public void setIsleaf(String isleaf) {
        this.isleaf = isleaf;
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }

    public String getIscommon() {
        return iscommon;
    }

    public void setIscommon(String iscommon) {
        this.iscommon = iscommon;
    }

    public String getOrdnumber() {
        return ordnumber;
    }

    public void setOrdnumber(String ordnumber) {
        this.ordnumber = ordnumber;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getStateid() {
        return stateid;
    }

    public void setStateid(String stateid) {
        this.stateid = stateid;
    }

    public String getStatelabel() {
        return statelabel;
    }

    public void setStatelabel(String statelabel) {
        this.statelabel = statelabel;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", parentid=").append(parentid);
        sb.append(", label=").append(label);
        sb.append(", fulllabel=").append(fulllabel);
        sb.append(", isleaf=").append(isleaf);
        sb.append(", spell=").append(spell);
        sb.append(", iscommon=").append(iscommon);
        sb.append(", ordnumber=").append(ordnumber);
        sb.append(", floor=").append(floor);
        sb.append(", stateid=").append(stateid);
        sb.append(", statelabel=").append(statelabel);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
