package com.example.restfulservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author corn
 * @version 1.0.0
 */

@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    // 配置首页
    // 所有的WebMvcConfigurerAdapter组件会一起作用
    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {

        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("Signin");
                registry.addViewController("/index.html").setViewName("Signin");
            }
        };

        return adapter;
    }
}
