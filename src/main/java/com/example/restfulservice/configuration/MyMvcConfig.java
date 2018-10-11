package com.example.restfulservice.configuration;

import com.example.restfulservice.Interceptor.LoginHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author corn
 * @version 1.0.0
 */

@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    @Autowired
    LoginHandlerInterceptor loginHandlerInterceptor;


    // 所有的WebMvcConfigurerAdapter组件会一起作用
    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {

        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            // 配置页面映射
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("Signin");
                registry.addViewController("/index.html").setViewName("Signin");
                registry.addViewController("/main.html").setViewName("/emp/list");
            }

            // 配置拦截器
            // 其中springboot已经对静态资源做了处理，可以访问到
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(loginHandlerInterceptor).addPathPatterns("/**")
                        .excludePathPatterns("/", "/index.html", "/user/signin");
                super.addInterceptors(registry);
            }
        };

        return adapter;
    }


}
