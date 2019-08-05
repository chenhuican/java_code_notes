package com.imooc.manager.configurations;

import com.imooc.manager.controller.ProductController;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.awt.*;

/**
 * swagger 配置类
 * groupName 分组
 * swagger 集成文档：
 * http://springfox.github.io/springfox/docs/current/
 */

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket controllerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("controller")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(ProductController.class.getPackage().getName()))
//                .paths(PathSelectors.ant("/products/*"))
                .build();

    }

    @Bean
    public Docket defaultApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(BasicErrorController.class.getPackage().getName()))
                .build();

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("HTTP API")
                .description("管理端口")
                .termsOfServiceUrl("http://springfox.github.io/springfox/")
                .contact("imooc")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.baidu.com")
                .version("2.0")
                .build();
    }
}
