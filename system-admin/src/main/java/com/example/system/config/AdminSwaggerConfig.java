package com.example.system.config;


import com.example.system.common.config.BaseSwaggerConfig;
import com.example.system.common.config.SwaggerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger2API文档的配置
 * 配置Api文档
 */
@Configuration
@EnableOpenApi
//@EnableKnife4j
public class AdminSwaggerConfig extends BaseSwaggerConfig {
    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .groupName("admin")
                .enable(true)
                .applicationName("用户模块")
                .version("1.0")
                .description("管理用户账号、权限、角色、组织等")
                .build();
    }
    @Bean("user")
    public Docket expandApi(){
        return createDocket()
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.system.controller"))
                .build();
    }
}
