package com.example.system.dao;

import com.example.system.mbg.model.UmsAdminRoleRelation;
import com.example.system.mbg.model.UmsResource;
import com.example.system.mbg.model.UmsRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UmsAdminRoleRelationDao {
    /**
     * 根据用户Id获取资源列表
     * @param adminId
     * @return
     */
    List<UmsResource> getResourceList(@Param("adminId") Long adminId);

    /**
     * 获取拥有该资源的用户Id列表
     * @param resourceId
     * @return
     */
    List<Long> getAdminIdList(Long resourceId);

    /**
     * 批量插入
     * @param list
     */

    void insertList(List<UmsAdminRoleRelation> list);

    List<UmsRole> getRoleList(Long adminId);
}