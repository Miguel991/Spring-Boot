package com.hmc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hmc.component.ExampleComponent;
import com.hmc.model.Person;
import com.hmc.service.ExampleService;


@Controller
@RequestMapping("/example")
public class ExampleController {
	
	@Autowired
	@Qualifier("component")
	private ExampleComponent component;
	
	@Autowired
	@Qualifier("exampleService")
	private ExampleService  exService;
	
	@GetMapping("/exampleString")
	public String exampleString(Model model){
		component.sayHello(); //inyeccion del componente que creamos
		//retorna el nombre de la vista
		model.addAttribute("people", exService.getListPeople());
		return "example";
	}
	
	@GetMapping("/exampleMAV")
	public ModelAndView exampleMAV(){
		ModelAndView mav = new ModelAndView("example");
		mav.addObject("people", exService.getListPeople());//<---- inyectamos el objeto con autowired desde la clase ExampleServiceImpl
		return mav;										// que utiliza la interface ExampleService
	}

}
