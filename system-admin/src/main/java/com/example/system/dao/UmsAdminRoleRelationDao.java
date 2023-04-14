package com.example.system.dao;

import com.example.system.mbg.model.UmsPermission;
import com.example.system.mbg.model.UmsResource;
import com.example.system.mbg.model.UmsRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UmsAdminRoleRelationDao {

    /**
     * 获取用户所有权限(包括+-权限)
     */
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);
    List<UmsPermission> getPermissionListByUri(@Param("uri") String uri);
    List<UmsRole> getRoleList(@Param("adminId") Long adminId);
    List<UmsResource> getResourceList(@Param("adminId") Long adminId);
}