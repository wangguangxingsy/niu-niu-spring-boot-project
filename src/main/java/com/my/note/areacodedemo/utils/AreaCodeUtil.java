package com.my.note.areacodedemo.utils;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.my.note.areacodedemo.dto.AreaCodeResDTO;
import com.my.note.areacodedemo.entity.Azx12;
import com.my.note.mapper.Azx12Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 全国统一区划代码 处理器
 *
 * @Author：wangguangxing
 * @Date：2024-12-05 20:23
 * @Description：
 */
@Component
public class AreaCodeUtil {

    @Autowired
    private Azx12Mapper azx12Mapper;


    /**
     * 全国统一区划代码工具类（最后面层级不变）
     *
     * @param level 层级
     *              0：中国-省-市-区-街道-社区
     *              1：省-市-区-街道-社区
     *              2：市-区-街道-社区
     *              3：区-街道-社区
     *              4：街道-社区
     *              5：社区
     * @return
     */
    public List<Azx12> parseAreasBackByLevel(int level) {
        //查询全国区划信息
        List<Azx12> azx12s = azx12Mapper.selectList(null);
        // 创建一个Map来存储每个分类对象，键是分类ID
        Map<String, Azx12> map = new HashMap<>();
        for (Azx12 category : azx12s) {
            map.put(category.getValue(), category);
        }
        // 准备一个列表来保存根节点
        List<Azx12> rootCategories = new ArrayList<>();
        for (Azx12 category : azx12s) {
            // 如果当前分类没有父级分类ID或者父级ID为"0"，则认为它是根节点
            if (category.getParentid() == null || "AreaCode_Full".equals(category.getParentid())) {
                rootCategories.add(category);
                //层级关系
                category.setLevel(0);
            } else {
                // 根据当前 Azx12 分类对象（category）的 parentid 来查找对应的父级分类对象，并将其赋值给 parent 变量。这是构建层级关系的第一步，只有先准确找到父级对象，后续才能把当前对象关联到父级对象之下，形成正确的层级结构。
                Azx12 parent = map.get(category.getParentid());
                if (parent != null) {
                    if (parent.getChildren() == null) {
                        parent.setChildren(new ArrayList<>());// 初始化子节点列表
                    }
                    //随着对所有 Azx12 对象的遍历和这样的操作执行，整个全国区划的树形层级结构就逐步构建起来了。
                    parent.getChildren().add(category);
                    //层级关系
                    category.setLevel(parent.getLevel() + 1);
                }
            }
        }
        List<Azx12> targetLevelCategories = new ArrayList<>();
        for (Azx12 azx12 : rootCategories) {
            findNodesByLevel(azx12, level, targetLevelCategories);
        }
        return targetLevelCategories;
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
    public AreaCodeResDTO parseAreasFrontByLevel(int level) {
        //存放全国区划信息
        AreaCodeResDTO nationLevelDTO = new AreaCodeResDTO();
        nationLevelDTO.setValue("000000000000");
        nationLevelDTO.setLabel("中国");
        LambdaQueryWrapper<Azx12> wrapper = new LambdaQueryWrapper<>();
        //查询全国区划信息
        List<Azx12> azx12s = this.azx12Mapper.selectList(wrapper);
        //省级
        List<Azx12> provinceResList = azx12s.stream().filter(e -> (floor(e.getValue()) == 1)).
                collect(Collectors.toList());
        List<AreaCodeResDTO> nationLevelArray = new ArrayList<>();
        provinceResList.stream().forEach(e -> {
            AreaCodeResDTO provinceObject = new AreaCodeResDTO();
            //循环每个省
            provinceObject.setValue(e.getValue());//省id
            provinceObject.setLabel(e.getLabel());//省name
            if (1 != level) {
                //省份前三位
                String filter = e.getValue().substring(0, 3);
                //获取该省份下的所有区划
                List<Azx12> list = azx12s.stream().filter(f -> f.getValue().startsWith(filter)).collect(Collectors.toList());
                List<AreaCodeResDTO> provinceLevelArray = getProvinceChildren(list, level);
                provinceObject.setChildren(provinceLevelArray);
            }
            nationLevelArray.add(provinceObject);
        });
        nationLevelDTO.setChildren(nationLevelArray);
        return nationLevelDTO;
    }

    /**
     * 递归查找指定层级节点的方法
     *
     * @param azx12
     * @param level
     * @param targetLevelCategories
     */
    private void findNodesByLevel(Azx12 azx12, int level, List<Azx12> targetLevelCategories) {
        if (level == azx12.getLevel()) {
            targetLevelCategories.add(azx12);
        }
        List<Azx12> children = azx12.getChildren();
        if (null != children) {
            for (Azx12 item : children) {
                findNodesByLevel(item, level, targetLevelCategories);
            }
        }
    }


    /**
     * 根据行政区划尾数判断层级
     *
     * @param zoneCode
     * @return
     */
    public int floor(String zoneCode) {
        if (zoneCode.endsWith("0000000000") && !zoneCode.endsWith("000000000000")) {
            return 1; // 省级
        } else if (zoneCode.endsWith("00000000") && !zoneCode.endsWith("000000000")) {
            return 2; // 市级
        } else if (zoneCode.endsWith("000000")) {
            return 3; // 区级
        } else if (zoneCode.endsWith("000")) {
            return 4; // 街道级级
        } else {
            return 5; // 社区级
        }
    }

    /**
     * 获取该省份下的所有children子节点（市）
     *
     * @param azx12s 数据库里行政区划查询结果集
     * @return
     */
    private List<AreaCodeResDTO> getProvinceChildren(List<Azx12> azx12s, int level) {
        List<AreaCodeResDTO> cityLevelArray = new ArrayList<>();
        //市级
        List<Azx12> cityResList = azx12s.stream().filter(e -> (floor(e.getValue()) == 2)).
                collect(Collectors.toList());
        //区级
        List<Azx12> areaResList = azx12s.stream().filter(e -> (floor(e.getValue()) == 3)).
                collect(Collectors.toList());
        //根据市id分组，获取各个【市】对应下面各个区
        Map<String, List<Azx12>> areaListByParentid = areaResList.stream()
                .collect(Collectors.groupingBy(Azx12::getParentid));
        //市级id集合
        Set<String> cityKeys = areaListByParentid.keySet();
        for (String cityKey : cityKeys) {
            // 市级别DTO
            AreaCodeResDTO cityLevelDTO = new AreaCodeResDTO();
            List<Azx12> cityNameList = cityResList.stream().filter(e -> e.getValue().equals(cityKey))
                    .collect(Collectors.toList());
            if (!cityNameList.isEmpty()) {
                String cityName = cityNameList.get(0).getLabel();
                //市级name
                cityLevelDTO.setLabel(cityName);
                cityLevelDTO.setValue(cityKey);//市级id
                if (2 != level) {
                    List<AreaCodeResDTO> areaLevelArray = getCityChildren(azx12s, areaListByParentid, cityKey, level);
                    //获取该市级（f）下的所有children子节点（区）
                    cityLevelDTO.setChildren(areaLevelArray);
                }
                cityLevelArray.add(cityLevelDTO);
            }
        }
        return cityLevelArray;
    }

    /**
     * 获取该市下的所有children子节点（区）
     *
     * @param azx12s             数据库里行政区划查询结果集
     * @param areaListByParentid 根据市id进行分组的区list
     * @param cityKey            市id
     * @return
     */
    private List<AreaCodeResDTO> getCityChildren(List<Azx12> azx12s, Map<String, List<Azx12>> areaListByParentid, String cityKey, int level) {
        List<AreaCodeResDTO> areaLevelArray = new ArrayList<>();
        //获取该市id下的区list
        List<Azx12> areaList = areaListByParentid.get(cityKey);
        if (!areaList.isEmpty()) {
            areaList.stream().forEach(f -> {
                AreaCodeResDTO areaLevel = new AreaCodeResDTO();// 区信息
                areaLevel.setLabel(f.getLabel());// 区name
                areaLevel.setValue(f.getValue());// 区id
                // 获取该区级（f）下的所有children子节点（街道）
                if (3 != level) {
                    List<AreaCodeResDTO> streetLevelArray = getAreaChildren(azx12s, f, level);
                    areaLevel.setChildren(streetLevelArray);
                }
                areaLevelArray.add(areaLevel);
            });
        }
        return areaLevelArray;
    }

    /**
     * 获取该街道下的所有children子节点
     *
     * @param azx12s 数据库里行政区划查询结果集
     * @param f      区信息
     * @return
     */
    private List<AreaCodeResDTO> getAreaChildren(List<Azx12> azx12s, Azx12 f, int level) {
        //存放街道list
        List<AreaCodeResDTO> streetLevelArray = new ArrayList<>();
        //获取该市下所有街道list
        List<Azx12> streetResList = azx12s.stream().filter(e -> (floor(e.getValue()) == 4)).
                collect(Collectors.toList());
        //根据区ID,将街道进行分组
        Map<String, List<Azx12>> streetListByParentid = streetResList.stream()
                .collect(Collectors.groupingBy(Azx12::getParentid));
        //区id集合
        Set<String> areaKeys = streetListByParentid.keySet();
        if (areaKeys.contains(f.getValue())) {
            if (!streetListByParentid.isEmpty()) {
                //街道list
                List<Azx12> streetList = streetListByParentid.get(f.getValue());
                if (!streetList.isEmpty()) {
                    streetList.stream().forEach(d -> {
                        AreaCodeResDTO streetLevel = new AreaCodeResDTO();// 街道信息
                        streetLevel.setLabel(d.getLabel());//街道name
                        streetLevel.setValue(d.getValue());//街道id
                        //获取该街道（d）下的所有children子节点（社区）
                        if (4 != level) {
                            List<AreaCodeResDTO> commLevelArray = getStreetChildren(azx12s, d);
                            streetLevel.setChildren(commLevelArray);
                        }
                        streetLevelArray.add(streetLevel);
                    });
                }
            }
        }
        return streetLevelArray;
    }

    /**
     * 获取该街道下的所有children子节点
     *
     * @param azx12s 数据库里行政区划查询结果集
     * @param d      街道信息
     * @return
     */
    private List<AreaCodeResDTO> getStreetChildren(List<Azx12> azx12s, Azx12 d) {
        // 存放社区list
        List<AreaCodeResDTO> commLevelArray = new ArrayList<>();
        // 获取该省份所有社区list
        List<Azx12> commResList = azx12s.stream().filter(e -> (floor(e.getValue()) == 5)).
                collect(Collectors.toList());
        // 根据街道ID,将社区级进行分类
        Map<String, List<Azx12>> communityCollectById = commResList.stream()
                .collect(Collectors.groupingBy(Azx12::getParentid));
        //街道id集合
        Set<String> commKeys = communityCollectById.keySet();
        if (commKeys.contains(d.getValue())) {
            if (!communityCollectById.isEmpty()) {
                //根据街道id，获取下面的社区list
                communityCollectById.get(d.getValue()).stream().forEach(e -> {
                    AreaCodeResDTO commLevel = new AreaCodeResDTO();// 街道信息
                    commLevel.setLabel(e.getLabel());//社区name
                    commLevel.setValue(e.getValue());//社区id
                    commLevelArray.add(commLevel);
                });
            }
        }
        return commLevelArray;
    }


    /**
     * 递归查找父id，并组成新的Azx12（id、parentid、label）
     *
     * @return
     */
    public static List<Azx12> findParentNode(Azx12 azx12) {
        List<Azx12> parentResultList = new ArrayList<>();
        if (null != azx12 && !azx12.getChildren().isEmpty()) {
            for (Azx12 item : azx12.getChildren()) {
                //递归调用，匹配父id
                findParentId(item, parentResultList);
            }
        }
        return parentResultList;
    }

    /**
     * 递归查找父节点，并组成新的Azx12（id、parentid、label）
     *
     * @param azx12
     * @return
     */
    private static List<Azx12> findParentId(Azx12 azx12, List<Azx12> parentResultList) {
        List<Azx12> children = azx12.getChildren();
        if (null != children) {
            for (Azx12 item : children) {
                Azx12 result = new Azx12();
                //父id
                result.setParentid(azx12.getValue());
                //id
                result.setValue(item.getValue());
                //label
                result.setLabel(item.getLabel());
                //放到新集合
                parentResultList.add(result);
                //递归调用
                findParentId(item, parentResultList);
            }
        }
        return parentResultList;
    }
}
