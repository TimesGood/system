package com.example.system.common.config;

import lombok.Builder;

@Builder
public class SwaggerProperties {
    /**
     * 是否开启swagger，生产环境一般关闭，所以这里定义一个变量
     */
    private Boolean enable;
 
    /**
     * 项目应用名
     */
    private String applicationName;
 
    /**
     * 项目版本信息
     */
    private String version;
 
    /**
     * 项目描述信息
     */
    private String description;
 
    public Boolean getEnable() {
        return enable;
    }
 
    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
 
    public String getApplicationName() {
        return applicationName;
    }
 
    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }
 
    public String getVersion() {
        return version;
    }
 
    public void setversion(String version) {
        this.version = version;
    }
 
    public String getDescription() {
        return description;
    }
 
    public void setDescription(String description) {
        this.description = description;
    }
}