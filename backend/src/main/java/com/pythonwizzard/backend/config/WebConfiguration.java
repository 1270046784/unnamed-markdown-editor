package com.pythonwizzard.backend.config;

import com.pythonwizzard.backend.interceptor.AuthorizeInterceptor;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Resource
    private AuthorizeInterceptor authorizeInterceptor = new AuthorizeInterceptor();

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
                .addInterceptor(authorizeInterceptor)
                .addPathPatterns("/api/user/info");  // 将拦截器添加在用户相关路由
//                .excludePathPatterns("/api/**");  // 放行管理
    }

}
