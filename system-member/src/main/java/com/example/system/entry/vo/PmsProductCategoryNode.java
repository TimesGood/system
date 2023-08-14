package com.example.system.entry.vo;

import com.example.system.mbg.model.PmsProductCategory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 包含子分类的商品分类
 */
@Getter
@Setter
public class PmsProductCategoryNode extends PmsProductCategory {
    @ApiModelProperty("子分类集合")
    private List<PmsProductCategoryNode> children;
}
