package com.example.system.search.config;

import com.example.system.common.config.BaseSwaggerConfig;
import com.example.system.common.config.SwaggerProperties;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig extends BaseSwaggerConfig {
    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .enable(true)
                .applicationName("商品搜索管理")
                .description("ES搜索引擎")
                .version("1.0")
                .build();
    }

    @Bean
    public BeanPostProcessor generateBeanPostProcessor() {
        return super.generateBeanPostProcessor();
    }
}
