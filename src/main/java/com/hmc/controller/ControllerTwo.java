package com.hmc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/controllerTwo")
public class ControllerTwo {
	
	private static final String VIEW = "exampleTwo";
	
	//localhost:8080/exampleTwo/requestOne?name=jon
	@GetMapping("/requestOne")
	public ModelAndView requestOne(@RequestParam(name="name", required=false, defaultValue="Sin Registros para el usuario") String name){
		ModelAndView mav = new ModelAndView(VIEW);
		mav.addObject("nameInModel", name);
		return mav;
	}
	
	//localhost:8080/controllerTwo/requestOne/Maikel
	@GetMapping("/requestTwo/{name}")
	public ModelAndView requestTwo(@PathVariable("name") String name){
		ModelAndView mav = new ModelAndView(VIEW);
		mav.addObject("nameInModel", name);
		
		return mav;
	}
	
}
