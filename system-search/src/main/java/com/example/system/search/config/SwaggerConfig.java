package com.example.system.search.config;

import com.example.system.common.config.BaseSwaggerConfig;
import com.example.system.common.config.SwaggerProperties;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig extends BaseSwaggerConfig {
    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .groupName("searchApi")
                .enable(true)
                .applicationName("商品搜索管理")
                .description("ES搜索引擎")
                .version("1.0")
                .build();
    }

    @Bean("searchApi")
    public Docket expandApi(){
        return createDocket().select()
                .apis(RequestHandlerSelectors.basePackage("com.example.system.search.controller"))
                .build();
    }
}
