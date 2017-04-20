package com.hmc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hmc.model.Person;

@Controller
@RequestMapping("/example")
public class ExampleController {
	
	@GetMapping("/exampleString")
	public String exampleString(Model model){
		//retorna el nombre de la vista
		model.addAttribute("people", getPeople());
		return "example";
	}
	
	@GetMapping("/exampleMAV")
	public ModelAndView exampleMAV(){
		ModelAndView mav = new ModelAndView("example");
		mav.addObject("people",getPeople());
		return mav;
	}
	
	private List<Person> getPeople(){
		List<Person> people = new ArrayList<>();
		people.add(new Person("Juan",45));
		people.add(new Person("Jose",34));
		people.add(new Person("Antonio",23));
		people.add(new Person("Maria",12));
		
		return people;

	}

}
