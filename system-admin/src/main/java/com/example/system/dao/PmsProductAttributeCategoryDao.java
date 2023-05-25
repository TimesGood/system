package com.example.system.dao;
import com.example.system.entry.vo.PmsProductAttributeCategoryItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 商品属性分类管理自定义Dao
 */
@Mapper
public interface PmsProductAttributeCategoryDao {
    /**
     * 获取包含属性的商品属性分类
     */
    List<PmsProductAttributeCategoryItem> getListWithAttr();
}
