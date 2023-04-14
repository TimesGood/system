package com.example.system.config;

import com.example.system.service.UmsAdminService;
import com.example.system.service.UmsResourceService;
import com.example.system.mbg.model.UmsResource;
import com.example.system.security.component.dynamicSecurity.DynamicSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.userdetails.UserDetailsService;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class SysSecurityConfig {
    @Autowired
    private UmsAdminService adminService;
    @Autowired
    private UmsResourceService resourceService;

    /**
     * 获取用户信息
     * @return
     */
    @Bean
    public UserDetailsService userDetailsService() {
        //获取登录用户信息
        return username -> adminService.loadUserByUsername(username);
    }

    /**
     * 开启动态路径
     * @return
     */
    @Bean
    public DynamicSecurityService dynamicSecurityService() {
        return () -> {
            Map<String, ConfigAttribute> map = new ConcurrentHashMap<>();
            List<UmsResource> resourceList = resourceService.listAll();
            for (UmsResource resource : resourceList) {
                map.put(resource.getUrl(), new org.springframework.security.access.SecurityConfig(resource.getId() + ":" + resource.getName()));
            }
            return map;
        };
    }
}
