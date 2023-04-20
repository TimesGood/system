package com.example.system.security.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * 身份鉴权白名单
 */
@ConfigurationProperties("secure.ignored")
public class IgnoreUrlsProperties {
    private List<String> urls = new ArrayList<>();

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }
}
