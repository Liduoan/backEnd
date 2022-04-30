package com.liduoan.backend.config;

import com.liduoan.backend.config.header.CustomFilter;
import com.liduoan.backend.config.interceptor.BackInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
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
    BackInterceptor backInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(backInterceptor).addPathPatterns("/user/**", "/item/**");
    }

    static final String ORIGINS[] = new String[]{"GET", "POST", "PUT", "DELETE"};

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*").allowCredentials(true).allowedMethods(ORIGINS).maxAge(3600);
    }



    @Autowired
    private CustomFilter customFilter;

    @Bean
    public FilterRegistrationBean<CustomFilter> initFilterRegistrationBean() {
        FilterRegistrationBean<CustomFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(customFilter);
        registrationBean.addUrlPatterns("/**");
        registrationBean.setOrder(0);

        return registrationBean;
    }


//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")    //添加映射路径，“/**”表示对所有的路径实行全局跨域访问权限的设置
//                .allowedOrigins("*")    //开放哪些ip、端口、域名的访问权限
//                .allowCredentials(true)  //是否允许发送Cookie信息
//                .allowedMethods("GET", "POST", "PUT", "DELETE")     //开放哪些Http方法，允许跨域访问
//                .allowedHeaders("*")     //允许HTTP请求中的携带哪些Header信息
//                .exposedHeaders("*");   //暴露哪些头部信息（因为跨域访问默认不能获取全部头部信息）
//    }

}
