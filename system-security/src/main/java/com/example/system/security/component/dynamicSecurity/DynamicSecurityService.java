package com.example.system.security.component.dynamicSecurity;

import org.springframework.security.access.ConfigAttribute;

import java.util.Map;

/**
 * 基于路径动态权限业务
 */
public interface DynamicSecurityService {
    Map<String,ConfigAttribute> loadDataSource();
}
