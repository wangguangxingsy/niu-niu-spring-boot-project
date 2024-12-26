package com.my.note.listdemo;

import com.my.note.filedemo.BarDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * List 相关工具类
 *
 * @Author：勇敢牛牛
 * @Date：2024-12-19 16:02
 * @Description：
 */
public class ListUtil {


    /**
     * 两个list，对key值相同的value相加处理。如key不同，则进行合并
     *
     * @param list1
     * @param list2
     * @return
     */
    public static List<BarDO> listCompare(List<BarDO> list1, List<BarDO> list2) {
        Map<String, Integer> sumMap = new HashMap<>();
        if (null != list1 && !list1.isEmpty()) {
            list1.stream().forEach(e -> {
                sumMap.put(e.getKey(), sumMap.getOrDefault(e.getKey(), 0) + e.getValue());
            });
        }
        if (null != list2 && !list2.isEmpty()) {
            list2.stream().forEach(e -> {
                sumMap.put(e.getKey(), sumMap.getOrDefault(e.getKey(), 0) + e.getValue());
            });
        }
        //将map转为list
        List<BarDO> resultList = sumMap.entrySet().stream()
                .flatMap(e -> Stream.of(new BarDO(e.getKey(), e.getValue())))
                .collect(Collectors.toList());
        return resultList;
    }


    public static void main(String[] args) {
        List<BarDO> list1 = new ArrayList<>();
        list1.add(new BarDO("a", 1));
        list1.add(new BarDO("b", 3));
        list1.add(new BarDO("c", 5));
        List<BarDO> list2 = new ArrayList<>();
        list1.add(new BarDO("d", 2));
        list1.add(new BarDO("b", 2));
        list1.add(new BarDO("e", 1));
        System.out.println(listCompare(list1, list2));
        ;
    }

}
