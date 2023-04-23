package com.example.system.dao;

import com.example.system.entry.vo.SmsCouponHistoryDetail;
import com.example.system.mbg.model.SmsCoupon;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 会员优惠券领取记录管理自定义Dao
 */
@Mapper
public interface SmsCouponHistoryDao {
    /**
     * 获取优惠券历史详情
     */
    List<SmsCouponHistoryDetail> getDetailList(@Param("memberId") Long memberId);

    /**
     * 获取指定会员优惠券列表
     */
    List<SmsCoupon> getCouponList(@Param("memberId") Long memberId, @Param("useStatus")Integer useStatus);
}
