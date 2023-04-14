package com.example.system.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 */
@Configuration
@MapperScan({
        "com.example.system.mbg.mapper",
        "com.example.system.dao",
        "com.example.system.*.dao"
})//指定mapper配置扫描路径
public class MyBatisConfig {
}
