package com.my.note.areacodedemo.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.my.note.areacodedemo.dto.AreaCodeResDTO;
import com.my.note.areacodedemo.entity.Azx12;
import com.my.note.areacodedemo.utils.AreaCodeUtil;
import com.my.note.filedemo.FileUtil;
import com.my.note.mapper.Azx12Mapper;
import com.my.note.psninfodemo.PsnInfoUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 行政区划树表（系统用） 前端控制器
 * </p>
 *
 * @author 勇敢牛牛
 * @since 2024-11-30
 */
@RestController
@RequestMapping("/azx12")
public class Azx12Controller {

    @Autowired
    private AreaCodeUtil areaCodeUtil;

    @Autowired
    private Azx12Mapper azx12Mapper;

    /**
     * 全国统一区划代码工具类（最后面层级不变）
     *
     * @param level 0：中国-省-市-区-街道-社区
     *              1：省-市-区-街道-社区
     *              2：市-区-街道-社区
     *              3：区-街道-社区
     *              4：街道-社区
     *              5：社区
     * @return
     */
    @GetMapping("/parseAreasBackByLevel")
    public List<Azx12> parseAreasBackByLevel(@RequestParam int level) {
        return areaCodeUtil.parseAreasBackByLevel(level);
    }

    /**
     * 全国行政区划代码（最前面层级不变） 处理工具类
     *
     * @param level 层级
     *              1： 国家 - 省
     *              2： 国家 - 省 - 市
     *              3： 国家 - 省 - 市 - 区
     *              4： 国家 - 省 - 市 - 区 - 街道
     *              5:  国家 - 省 - 市 - 区 - 街道 - 社区
     * @return
     */
    @GetMapping("/parseAreasFrontByLevel")
    public AreaCodeResDTO parseAreasFrontByLevel(@RequestParam int level) {
        return areaCodeUtil.parseAreasFrontByLevel(level);
    }


    /**
     * 查询某一个省下面的市级区划（如：辽宁省 areaCode：210000000000）
     *
     * @param areaCode
     * @return
     */
    @GetMapping("/parseAreasByProvince")
    public AreaCodeResDTO parseAreasByProvince(@RequestParam String areaCode) {
        AreaCodeResDTO result = new AreaCodeResDTO();
        //先获取省市两级区划
        AreaCodeResDTO areaCodeResDTO = areaCodeUtil.parseAreasFrontByLevel(2);
        if (null != areaCodeResDTO) {
            areaCodeResDTO.getChildren().stream().forEach(e -> {
                //获取areaCode对象
                if (areaCode.equals(e.getValue())) {
                    BeanUtils.copyProperties(e, result);
                }
            });
        }
        return result;
    }


    /**
     * 将辽宁省行政区划的json文件，保存到数据库中
     *
     * @return
     */
    @GetMapping("/insertAzx12")
    public int insertAzx12() {
        //将行政区划的json文件转为Azx12类
        Azx12 azx12 = FileUtil.fileToAzx12();
        //递归查找父id，并组成新的Azx12（id、parentid、label）
        List<Azx12> parentIdList = AreaCodeUtil.findParentNode(azx12);
        for (Azx12 e : azx12.getChildren()) {
            //添加第二层父级信息
            e.setParentid(azx12.getValue());
            parentIdList.add(e);
        }
        int total = 0;
        for (Azx12 item : parentIdList) {
            LambdaQueryWrapper<Azx12> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(Azx12::getValue, item.getValue());
            Integer count = azx12Mapper.selectCount(wrapper);
            if (count == 0) {
                //库里不存在，进行新增
                int a = azx12Mapper.insert(item);
                total += a;
            }
        }
        return total;
    }
}

