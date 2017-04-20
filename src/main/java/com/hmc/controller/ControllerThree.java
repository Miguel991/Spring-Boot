package com.hmc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hmc.model.Person;

@Controller
@RequestMapping("/controllerThree")
public class ControllerThree {
	
	public static final String VIEWFORM = "form";//html file name
	public static final String RESULTVIEW = "result";
	
	@GetMapping("/showform")
	public String showForm(Model model){
		model.addAttribute("person", new Person());
		return VIEWFORM;
	}
	
	@PostMapping("/addperson")
	public ModelAndView addPerson(@ModelAttribute("person") Person person){
		ModelAndView mav = new ModelAndView(RESULTVIEW);
		mav.addObject("person", person);
		return mav;
	
	}

}
