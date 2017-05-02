package com.hmc.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component("requestTime")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter{
	
	private static final Log log = LogFactory.getLog(RequestTimeInterceptor.class);

	//first
	//antes de entrar en el metodo del controlador
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("startTime", System.currentTimeMillis());
		return true;
	}
	//second
	//antes de mostrar la vista en el controlador 
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long startTime = (long) request.getAttribute("startTime");
		log.info("Request url: " + request.getRequestURL().toString() + "| total time: " + (System.currentTimeMillis() - startTime) + "ms");
	}

	
	

}
