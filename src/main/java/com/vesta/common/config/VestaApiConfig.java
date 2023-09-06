package com.vesta.common.config;

import com.vesta.common.intercept.ApiBeforeIntercept;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class VestaApiConfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ApiBeforeIntercept()).addPathPatterns("/vesta/data/*");
    }
}
