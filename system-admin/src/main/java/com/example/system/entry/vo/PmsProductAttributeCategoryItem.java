package com.example.system.entry.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import com.example.system.mbg.model.PmsProductAttributeCategory;
import com.example.system.mbg.model.PmsProductAttribute;

import java.util.List;

/**
 * 带有属性的商品属性分类
 */
public class PmsProductAttributeCategoryItem extends PmsProductAttributeCategory {
    @Getter
    @Setter
    @ApiModelProperty(value = "商品属性列表")
    private List<PmsProductAttribute> productAttributeList;
}
