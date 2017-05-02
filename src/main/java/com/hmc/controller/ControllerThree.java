package com.hmc.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.hmc.model.Person;

@Controller
@RequestMapping("/controllerThree")
public class ControllerThree {
	
	private static final Log logger = LogFactory.getLog(ControllerThree.class);
	
	public static final String VIEWFORM = "form";//html file name
	public static final String RESULTVIEW = "result";
	
	
//	@GetMapping("/")
//	public String redirect(){
//		return "redirect:/controllerThree/showform";
//	}
	//redireccionar a otra ruta
	@GetMapping("/")
	public RedirectView redirectView(){
		return new RedirectView("/controllerThree/showform");
	}
	
	@GetMapping("/showform")
	public String showForm(Model model){
		model.addAttribute("person", new Person());
		return VIEWFORM;
	}
	
	@PostMapping("/addperson")
	public ModelAndView addPerson(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult){
		ModelAndView mav = new ModelAndView();		
		if (bindingResult.hasErrors()){
			mav.setViewName(VIEWFORM);
		}else{
			mav.setViewName(RESULTVIEW);
			mav.addObject("person", person);
		}
		return mav;
	
	}

}
