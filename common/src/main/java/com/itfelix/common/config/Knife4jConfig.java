package com.itfelix.common.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Knife4jConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("AI面试官接口文档")
                        .description("AI面试官后端API接口文档")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("itfelix")
                                .email("felix@gmail.com")));
    }
}