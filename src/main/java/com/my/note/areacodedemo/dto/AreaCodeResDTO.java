package com.my.note.areacodedemo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 全国行政区划代码出参 DTO
 */

@Data
public class AreaCodeResDTO implements Serializable {

    private static final long serialVersionUID = 1L; // 建议定义一个版本号，便于版本兼容控制

    @ApiModelProperty(value = "市/区/街道级区划ID", required = true)
    private String value;

    @ApiModelProperty(value = "市/区/街道级区划名称", required = true)
    private String label;

    @ApiModelProperty(value = "区/街道级信息", required = true)
    private List<AreaCodeResDTO> children;

}
