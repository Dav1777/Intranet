package com.saf.intranet.infra.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginInterceptorAppConfig implements WebMvcConfigurer {
    private final Logininterceptor logininterceptor;

    public LoginInterceptorAppConfig(Logininterceptor logininterceptor){
        this.logininterceptor = logininterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(logininterceptor).excludePathPatterns(
                "/login",
                "/logar",
                "/cadastro",
                "/css/**",
                "/js/**"
        );
    }
}
