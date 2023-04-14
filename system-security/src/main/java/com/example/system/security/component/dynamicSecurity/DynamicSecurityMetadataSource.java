package com.example.system.security.component.dynamicSecurity;

import cn.hutool.core.util.URLUtil;

import com.example.system.common.api.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.CollectionUtils;
import org.springframework.util.PathMatcher;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 动态权限数据源
 * 作用获取配置该资源的所需权限
 */
public class DynamicSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    private static Map<String,ConfigAttribute> configAttributeMap = null;

    @Autowired
    private DynamicSecurityService dynamicSecurityService;

    public void loadDataSource(){
        configAttributeMap = dynamicSecurityService.loadDataSource();
    }

    public void clearDataSource(){
        configAttributeMap.clear();
        configAttributeMap = null;
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        if(configAttributeMap == null) loadDataSource();
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        String path = URLUtil.getPath(requestUrl);
        PathMatcher pathMatcher = new AntPathMatcher();
        //筛选配置有该资源的资源
        List<ConfigAttribute> collect = configAttributeMap
                .entrySet()
                .stream()
                .filter(f -> pathMatcher.match(f.getKey(), path))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
        if(!CollectionUtils.isEmpty(collect)) return collect;
        //没有配置访问资源的权限时，拒绝访问
        return SecurityConfig.createList(ResultCode.FORBIDDEN.getMessage());
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
