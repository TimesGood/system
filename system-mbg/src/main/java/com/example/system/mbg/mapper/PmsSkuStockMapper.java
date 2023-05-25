package com.example.system.mbg.mapper;

import com.example.system.mbg.model.PmsSkuStock;
import com.example.system.mbg.model.PmsSkuStockExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface PmsSkuStockMapper {
    long countByExample(PmsSkuStockExample example);

    int deleteByExample(PmsSkuStockExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsSkuStock record);

    int insertSelective(PmsSkuStock record);

    List<PmsSkuStock> selectByExample(PmsSkuStockExample example);

    PmsSkuStock selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsSkuStock record, @Param("example") PmsSkuStockExample example);

    int updateByExample(@Param("record") PmsSkuStock record, @Param("example") PmsSkuStockExample example);

    int updateByPrimaryKeySelective(PmsSkuStock record);

    int updateByPrimaryKey(PmsSkuStock record);
}