package com.newland.nideshopserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.newland.nideshopserver.intercepter.LoginIntercepter;

/**
 * @author xzt @CREATE2019-10-25 16:18 将拦截器添加到springBoot的配置中
 */
@Configuration
public class SessionConfiguration extends WebMvcConfigurerAdapter {

	@Autowired
	private LoginIntercepter loginIntercepter;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 拦截所有请求
		registry.addInterceptor(loginIntercepter).addPathPatterns("/**");
	}
}
