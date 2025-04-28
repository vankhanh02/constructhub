package com.constructhub.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("ConstructHub API")
                        .description("API for construction project management system")
                        .version("1.0")
                        .contact(new Contact()
                                .name("ConstructHub Team")
                                .email("support@constructhub.com")));
    }
}