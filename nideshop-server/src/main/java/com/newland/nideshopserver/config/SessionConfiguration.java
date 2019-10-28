package com.newland.nideshopserver.config;

import com.newland.nideshopserver.intercepter.LoginIntercepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author xzt
 * @CREATE2019-10-25 16:18
 * 将拦截器添加到springBoot的配置中
 */
@Configuration
public class SessionConfiguration extends WebMvcConfigurerAdapter {
    

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截所有请求
        registry.addInterceptor(new LoginIntercepter()).addPathPatterns("/**");
    }
}
