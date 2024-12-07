package com.my.note.areacode.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 全国行政区划代码出参 DTO
 */

@Data
public class AreaCodeResDTO {

    @ApiModelProperty(value = "市/区/街道级区划ID", required = true)
    private String value;

    @ApiModelProperty(value = "市/区/街道级区划名称", required = true)
    private String label;

    @ApiModelProperty(value = "区/街道级信息", required = true)
    private List<AreaCodeResDTO> children;

}
