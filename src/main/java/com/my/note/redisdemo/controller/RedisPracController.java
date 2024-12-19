package com.my.note.redisdemo.controller;

import com.my.note.areacodedemo.dto.AreaCodeResDTO;
import com.my.note.areacodedemo.entity.Azx12;
import com.my.note.areacodedemo.utils.AreaCodeUtil;
import com.my.note.common.CommonResponse;
import com.my.note.redisdemo.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * redis使用
 *
 * @Author：勇敢牛牛
 * @Date：2024-12-09 10:36
 * @Description：
 */
@RestController
@RequestMapping("/redisPrac")
public class RedisPracController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Value("${note.redis.namespace}" + ":AREA_KEY_PREFIX_")
    private String AREA_KEY_PREFIX;

    @Value("${note.redis.namespace}" + ":AREA_LIST_KEY_PREFIX")
    private String AREA_LIST_KEY_PREFIX;

    @Autowired
    private AreaCodeUtil areaCodeUtil;


    @Autowired
    private RedisUtil redisUtil;

    /**
     * 从缓存获取区划代码-对象
     *
     * @param level
     * @return
     */
    @GetMapping("/getAreaFromRedis")
    public CommonResponse<?> getAreaFromRedis(int level) {
        String key = AREA_KEY_PREFIX + level;
        Object obj = redisUtil.get(key);
        return CommonResponse.success(obj);
    }

    /**
     * 从缓存获取区划代码-list（根据level获取，相当于根据level查询）
     *
     * @param level
     * @return
     */
    @GetMapping("/getAreaListFromRedis")
    public CommonResponse<?> getAreaListFromRedis(int level) {
        String key = AREA_LIST_KEY_PREFIX + level;
        Object obj = redisUtil.getList(key);
        return CommonResponse.success(obj);
    }

    /**
     * 获取全国区划代码并存入缓存中
     *
     * @return
     */
    public void areaCodeListToRedis() {
        for (int level = 1; level < 6; level++) {
            String key = AREA_LIST_KEY_PREFIX + level;
            List<Azx12> azx12List = areaCodeUtil.parseAreasBackByLevel(level);
            //value:list
            redisUtil.set(key, azx12List);
        }
    }

    /**
     * 获取全国区划代码并存入缓存中
     *
     * @return
     */
    public void areaCodeToRedis() {
        for (int level = 1; level < 6; level++) {
            String key = AREA_KEY_PREFIX + level;
            AreaCodeResDTO resDTO = areaCodeUtil.parseAreasFrontByLevel(level);
            //value:对象
            redisUtil.set(key, resDTO);
        }
    }


}
