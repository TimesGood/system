package com.example.system.dao;


import com.example.system.entry.vo.PmsProductCategoryWithChildrenItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 商品分类自定义Dao
 */
@Mapper
public interface PmsProductCategoryDao {
    /**
     * 获取商品分类及其子分类
     */
    List<PmsProductCategoryWithChildrenItem> listWithChildren();
}
