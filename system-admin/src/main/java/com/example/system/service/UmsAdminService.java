package com.example.system.service;

import com.example.system.entry.dto.UpdateAdminPasswordParam;
import com.example.system.mbg.model.UmsAdmin;
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
     * 根据用户Id获取用户信息
     * @param adminId
     * @return
     */
    UmsAdmin getAdminById(Long adminId);

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

    /**
     * 根据用户名获取用户，并且该接口要提供权限校验的规则列表
     * UserDetails交给Security做权限校验
     * @param username
     * @return
     */
    UserDetails loadUserByUsername(String username);

    /**
     * 获取用户可访问资源列表
     * @param adminId
     * @return
     */
    List<UmsResource> getResourceList(Long adminId);
    /**
     * 获取角色列表
     * @param adminId
     * @return
     */
    List<UmsRole> getRoleList(Long adminId);

    /**
     * 刷新token
     * @param oldToken
     * @return
     */
    String refreshToken(String oldToken);

    /**
     * 通过关键字，返回用户列表
     * @param keyword
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<UmsAdmin> list(String keyword, Integer pageSize, Integer pageNum);

    /**
     * 修改用户信息
     * @param id
     * @param admin
     * @return
     */
    int update(Long id, UmsAdmin admin);

    /**
     * 删除用户
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 更新用户角色
     * @param adminId
     * @param roleIds
     * @return
     */
    int updateRole(Long adminId,List<Long> roleIds);

    /**
     * 更新用户密码
     * @param param
     * @return
     */

    int updatePassword(UpdateAdminPasswordParam param);


    /**
     * 因为依赖循环问题，在这获取用户缓存操作
     * @return
     */
    UmsAdminCacheService getCacheService();
}