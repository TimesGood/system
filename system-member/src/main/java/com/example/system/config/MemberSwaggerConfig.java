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
public class MemberSwaggerConfig extends BaseSwaggerConfig {
    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .groupName("member")
                .applicationName("会员模块")
                .version("1.0")
                .description("购买物品等")
                .build();
    }
    @Bean("member")
    public Docket expandApi(){
        return createDocket()
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.system.controller"))
                .build();
    }
}
