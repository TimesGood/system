package com.example.system.dao;

import com.example.system.mbg.model.UmsResource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UmsAdminRoleRelationDao {
    List<UmsResource> getResourceList(@Param("adminId") Long adminId);
}