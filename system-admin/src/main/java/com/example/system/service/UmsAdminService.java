package com.example.system.service;

import com.example.system.mbg.model.UmsAdmin;
import com.example.system.mbg.model.UmsPermission;
import com.example.system.mbg.model.UmsResource;
import com.example.system.mbg.model.UmsRole;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * 后台管理员Service
 */
public interface UmsAdminService {
    /**
     * 根据用户名获取用户信息
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 注册功能
     */
    UmsAdmin register(UmsAdmin umsAdminParam);

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String username, String password);

    /**
     * 账号登出
     * @return
     */
    String logout();

    List<UmsResource> getResourceList(Long adminId);

    UserDetails loadUserByUsername(String username);
}