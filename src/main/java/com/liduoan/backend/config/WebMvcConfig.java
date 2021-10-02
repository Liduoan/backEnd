package com.liduoan.backend.config;

import com.liduoan.backend.config.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 全局异常处理
 *
 * @author liduoan
 * @date 2021年09月29日 0:12
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    MyInterceptor myInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor).addPathPatterns("/user/**","/item/**");;
    }
}
