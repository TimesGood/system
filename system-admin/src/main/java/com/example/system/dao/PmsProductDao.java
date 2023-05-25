package com.example.system.dao;

import com.example.system.entry.vo.PmsProductResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * 商品管理自定义Dao
 */
@Mapper
public interface PmsProductDao {
    /**
     * 获取商品编辑信息
     */
    PmsProductResult getUpdateInfo(@Param("id") Long id);
}
