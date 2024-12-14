package com.my.note.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author：勇敢牛牛
 * @Date：2024-12-09 17:22
 * @Description：
 */
@Data
public class CommonResponse<T> implements Serializable {

    private static final long serialVersionUID = 5778573516446596671L;
    public static int SUCCESS = 0;
    public static String MSG_SUCCESS = "成功";

    @ApiModelProperty(value = "返回代码：0-业务请求成功，-1-业务请求失败")
    private int code;

    @ApiModelProperty(value = "返回信息")
    private String msg;

    @ApiModelProperty(value = "返回数据")
    private T data;


    public static <T> CommonResponse<T> success(T data) {
        CommonResponse<T> response = new CommonResponse<>();
        response.setCode(SUCCESS);
        response.setMsg(MSG_SUCCESS);
        response.setData(data);
        return response;

    }
}
