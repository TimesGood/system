package com.example.system.bean;

import com.example.system.mbg.model.UmsAdmin;
import com.example.system.mbg.model.UmsPermission;
import com.example.system.mbg.model.UmsResource;
import com.example.system.mbg.model.UmsRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * SpringSecurity需要的用户详情
 */
public class AdminUserDetails implements UserDetails {
    private final UmsAdmin umsAdmin;
    private final List<UmsResource> resources;
    public AdminUserDetails(UmsAdmin umsAdmin, List<UmsResource> resources) {
        this.umsAdmin = umsAdmin;
        this.resources = resources;
    }
    /**
     * 指定校验权限的字段，权限最终交由AuthenticationManager管理
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return resources.stream()
                .map(role ->new SimpleGrantedAuthority(role.getId()+":"+role.getName()))
                .collect(Collectors.toList());
    }


    @Override
    public String getPassword() {
        return umsAdmin.getPassword();
    }

    @Override
    public String getUsername() {
        return umsAdmin.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return umsAdmin.getStatus().equals(1);
    }
}
