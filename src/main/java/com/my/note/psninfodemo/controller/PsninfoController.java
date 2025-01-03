package com.my.note.psninfodemo.controller;

import com.my.note.common.CommonResponse;
import com.my.note.psninfodemo.PsnInfoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 人员基本信息控制器
 *
 * @Author：wangguangxing
 * @Date：2025-01-03 14:12
 * @Description：
 */
@RestController
@RequestMapping("/psninfo")
public class PsninfoController {

    @Autowired
    private PsnInfoUtil psnInfoUtil;

    /**
     * 查询年龄分布区间数据，出参结构如下：
     * <p>
     * {
     * "axis": "20岁以下",
     * "manValue": 1,
     * "womenValue": 0
     * }
     * </p>
     *
     * @return
     */
    @PostMapping("/queryAgeRange")
    public CommonResponse<?> queryAgeRange() {
        return CommonResponse.success(psnInfoUtil.queryAgeRange());
    }
}
