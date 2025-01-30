package com.deivid.microservices.config;

import com.deivid.microservices.config.handler.BranchAndProfileValidationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class RegisterInterceptorConfig implements WebMvcConfigurer {

    private final BranchAndProfileValidationInterceptor branchAndProfileValidationInterceptor;

    public RegisterInterceptorConfig(BranchAndProfileValidationInterceptor branchAndProfileValidationInterceptor) {
        this.branchAndProfileValidationInterceptor = branchAndProfileValidationInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(branchAndProfileValidationInterceptor);
    }
}
