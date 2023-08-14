package com.example.system.service;

import com.example.system.common.api.CommonPage;
import com.example.system.mbg.model.PmsBrand;
import com.example.system.mbg.model.PmsProduct;

import java.util.List;

/**
 * 前台品牌管理Service
 */
public interface PmsPortalBrandService {
    /**
     * 分页获取推荐品牌
     */
    List<PmsBrand> recommendList(Integer pageNum, Integer pageSize);

    /**
     * 获取品牌详情
     */
    PmsBrand detail(Long brandId);

    /**
     * 分页获取品牌关联商品
     */
    CommonPage<PmsProduct> productList(Long brandId, Integer pageNum, Integer pageSize);
}
