package com.example.system.entry.vo;

import com.example.system.mbg.model.PmsProduct;
import com.example.system.mbg.model.PmsProductFullReduction;
import com.example.system.mbg.model.PmsProductLadder;
import com.example.system.mbg.model.PmsSkuStock;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 促销商品信息，包括sku、打折优惠、满减优惠
 */
@Getter
@Setter
public class PromotionProduct extends PmsProduct {
    //商品库存信息
    private List<PmsSkuStock> skuStockList;
    //商品打折信息
    private List<PmsProductLadder> productLadderList;
    //商品满减信息
    private List<PmsProductFullReduction> productFullReductionList;
}
