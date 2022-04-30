package com.liduoan.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author liduoan
 * @date 2021/09/28 22:57
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    //配置Swagger的Bean实例
    @Bean
    public Docket docket(Environment environment) {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(true)
                .groupName("liduoan")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.liduoan.backend.controller"))
                .build();
    }


    //配置Swagger 信息=apiInfo
    private ApiInfo apiInfo() {
        Contact contact = new Contact("liduoan", "http://liduoan.github.io", "1093762409@qq.com");
        return new ApiInfo("liduoan的API",
                "天若星河，喜乐康平",
                "1.0",
                "",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
