package com.example.system.config;


import com.example.system.common.config.BaseSwaggerConfig;
import com.example.system.common.config.SwaggerProperties;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.spring.web.plugins.WebFluxRequestHandlerProvider;
import springfox.documentation.spring.web.plugins.WebMvcRequestHandlerProvider;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Swagger2API文档的配置
 * 配置Api文档
 */
@Configuration
@EnableOpenApi
//@EnableKnife4j
public class SwaggerConfig extends BaseSwaggerConfig {
    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .enable(true)
                .applicationName("用户模块")
                .version("1.0")
                .description("管理用户账号、权限、角色、组织等")
                .build();
    }

    @Bean
    public BeanPostProcessor generateBeanPostProcessor() {
        return super.generateBeanPostProcessor();
    }
}
