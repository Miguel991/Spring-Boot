package com.hmc.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.hmc.component.RequestTimeInterceptor;

@Configuration
public class WebmvcConfiguration extends WebMvcConfigurerAdapter {
	
	@Autowired
	@Qualifier("requestTime")
	private RequestTimeInterceptor requestTime;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(requestTime);
	}
	
	

}
