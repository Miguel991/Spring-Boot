package com.hmc.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("controllerFour")
public class ControllerFour {
	
	private static final Log logger = LogFactory.getLog(ControllerFour.class);
	
	public static final String VIEW = "404";
	public static final String FIVEHUNDRED = "500";
	
	@GetMapping("/404")
	public String getFourHundred(Model model){
		model.addAttribute("hola");
		return VIEW;
	}
	
	@GetMapping("/500")
	public String getFiveHundred(){
		logger.debug("DEBUG");
		logger.error("Error");
		logger.info("Info");
		logger.warn("Warning");
		return FIVEHUNDRED;
	}

}
