package com.example.system.security.entry.vo;

import com.example.system.common.util.SpringUtil;
import com.example.system.security.properties.JwtProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenVo {
    private String token;
    private String tokenPrefix;

    public TokenVo(String token) {
        this.token = token;
        this.tokenPrefix = SpringUtil.getBean(JwtProperties.class).getTokenPrefix();
    }
}
