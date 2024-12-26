package com.my.note.filedemo;


import com.alibaba.fastjson.JSONObject;
import com.my.note.areacodedemo.entity.Azx12;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * 文件相关工具类
 *
 * @Author：勇敢牛牛
 * @Date：2024-12-19 11:24
 * @Description：
 */
public class FileUtil {

    /**
     * 获取json文件中的区划key、value，转出hashMap
     *
     * @return
     */
    public static HashMap<String, String> fileToMap() {
        InputStream inputStream = FileUtil.class.getClassLoader().getResourceAsStream("mock/admdvs.json");
        String str = new BufferedReader(new InputStreamReader(inputStream))
                .lines()
                .collect(Collectors.joining(System.lineSeparator()));
        HashMap<String, String> map = JSONObject.parseObject(str, HashMap.class);
        return map;
    }


    /**
     * 将行政区划的json文件转为Azx12
     *
     * @return
     */
    public static Azx12 fileToAzx12() {
        //读取行政区划json文件
        InputStream inputStream = FileUtil.class.getClassLoader().getResourceAsStream("mock/areaCode.json");
        String str = new BufferedReader(new InputStreamReader(inputStream))
                .lines()
                .collect(Collectors.joining(System.lineSeparator()));
        //转换为Azx12类
        Azx12 azx12 = JSONObject.parseObject(str, Azx12.class);
        return azx12;
    }

    public static void main(String[] args) {
        HashMap<String, String> map = fileToMap();
        System.out.println(map);
        //根据code获取name
        String name = map.get("110114");
        System.out.println(name);
    }
}
