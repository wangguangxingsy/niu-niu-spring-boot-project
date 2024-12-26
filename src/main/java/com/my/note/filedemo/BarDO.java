package com.my.note.filedemo;

import lombok.Data;

/**
 * @Author：勇敢牛牛
 * @Date：2024-10-29 10:21
 * @Description：
 */
@Data
public class BarDO {

    //key
    private String key;

    //value
    private int value;

    public BarDO(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public BarDO() {
    }
}
