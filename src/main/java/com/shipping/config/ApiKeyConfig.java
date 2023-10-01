package com.shipping.config;

import java.util.Set;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ApiKeyConfig implements WebMvcConfigurer {

    private final Set<String> validApiKeys = Set.of(
            "Ky4OZCyLwVVMrSbhuBRr5xtgxubeP59o",
            "zK4DO8517jDgFBhbZ3iXJMmPE9b0bIAP",
            "BWE0Q3e6es1vMrsoTdSbO9Vsxsjb7iZv");

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ApiKeyInterceptor(validApiKeys));
    }
}
