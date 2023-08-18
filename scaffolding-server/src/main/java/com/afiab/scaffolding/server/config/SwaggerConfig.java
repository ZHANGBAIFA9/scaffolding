package com.afiab.scaffolding.server.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/15 11:33
 * @Description:
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .apis(RequestHandlerSelectors.basePackage("com.afiab"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // todo title 修改
                .title("scaffolding API Doc")
                // todo 描述修改
                .description("This is a restful api document of scaffolding.")
                .termsOfServiceUrl("http://localhost:8081/api/docs")
                .contact(new Contact(
                        "prd 脚手架",
                        "https://localhost:8081/api/docs",
                        "1350862999@qq.com"))
                .version("1.0")
                .build();
    }
}
