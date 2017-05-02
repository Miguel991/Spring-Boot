package com.hmc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hmc.repository.BookJPARepository;

@Controller
@RequestMapping("/say")
public class HelloWorldController {
	
	@Autowired
	@Qualifier("bookRepository")
	private BookJPARepository repository;
	
	@GetMapping("/helloworld")
	public String helloWorld(){
		repository.findByPrice(14);
		return "helloworld";
	}

}
