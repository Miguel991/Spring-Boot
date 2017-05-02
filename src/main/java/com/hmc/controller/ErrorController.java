package com.hmc.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//le decimos a Spring que esta va a ser la clase encargada de gestionar los errores internos
@ControllerAdvice
public class ErrorController {
	
	public static final String ERRORVIEW = "error/500";
	
	@ExceptionHandler(Exception.class)
	public String showInternalServerError(){
		return ERRORVIEW;
	}

}
