package com.example.system.mbg;

/**
 * mybatis-generator代码生成器
 * 可根据数据库中某个表自动生成mapper接口，mapper.xml、dao实体类、Example
 * 用于生产MBG的代码
 */
public class Generator {
    public static void main(String[] args) throws Exception {
        GeneratorUtil.build();
    }
}