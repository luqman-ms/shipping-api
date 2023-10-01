package com.shipping.config;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ParameterType;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.shipping.controller"))
            .paths(PathSelectors.any())
            .build()
            // .securitySchemes(Collections.singletonList(apiKey()))
            // .securityContexts(Collections.singletonList(securityContext()))
            .globalRequestParameters(globalParameters())
            .apiInfo(apiInfo());
    }

    private List<RequestParameter> globalParameters() {
        List<RequestParameter> parameters = new ArrayList<>();
        parameters.add(new RequestParameterBuilder()
                .name("X-Api-Key")
                .description("use this -> Ky4OZCyLwVVMrSbhuBRr5xtgxubeP59o")
                .in(ParameterType.HEADER)
                .required(false)
                .build());
        return parameters;
    }

    private ApiKey apiKey() {
        return new ApiKey("Ky4OZCyLwVVMrSbhuBRr5xtgxubeP59o", "X-Api-Key", "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
            .securityReferences(Collections.singletonList(new SecurityReference("API Key", new AuthorizationScope[0])))
            .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("Shipping API")
            .description("Your API Description")
            .version("1.0.0")
            .contact(new Contact("Your Name", "Your Website", "your.email@example.com"))
            .build();
    }
}

