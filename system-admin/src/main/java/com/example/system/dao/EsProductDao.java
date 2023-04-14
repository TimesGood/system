package com.example.system.dao;

import com.example.system.document.EsProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 搜索系统中的商品管理自定义Dao
 */
@Mapper
public interface EsProductDao {
    List<EsProduct> getAllEsProductList(@Param("id") Long id);
}