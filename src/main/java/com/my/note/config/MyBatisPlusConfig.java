package com.my.note.config;


import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author：wangguangxing
 * @Date：2024-11-30 15:16
 * @Description：
 */
@Configuration
@MapperScan("com.my.note.area.mapper")
public class MyBatisPlusConfig {

    /*
   分页插件
    */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
