package com.example.system.common.config;

import lombok.Builder;

@Builder
public class SwaggerProperties {
    private String groupName;

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

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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