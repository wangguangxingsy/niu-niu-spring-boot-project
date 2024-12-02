package com.my.note;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.my.note.area.entity.Azx12;
import com.my.note.area.mapper.Azx12Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author：wangguangxing
 * @Date：2024-11-29 13:55
 * @Description：
 */
@RestController
public class HelloWorldController {

    //@Autowired
    //private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private Azx12Mapper azx12Mapper;

    @GetMapping("/")
    public String helloWorld() {
        List<Azx12> list = azx12Mapper.selectAll();

        LambdaQueryWrapper<Azx12> wrapper = new LambdaQueryWrapper<Azx12>();
        //例如指定为沈阳市
        //wrapper.eq(Azx12::getParentid, "2101");
        wrapper.likeRight(Azx12::getParentid, "2101");
        List<Azx12> azx12s = azx12Mapper.selectList(wrapper);
        //redisTemplate.opsForValue().set("test", "note");
        //System.out.println("redis取值：" + redisTemplate.opsForValue().get("test"));
        return "Hello World";
    }
}
