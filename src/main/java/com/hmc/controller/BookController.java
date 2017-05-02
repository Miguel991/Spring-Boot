package com.hmc.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hmc.entity.BookStore;
import com.hmc.service.BookService;


@Controller
@RequestMapping("/books")
public class BookController {
	
	private static final String BOOKPAGE = "bookpage";
	private static final Log log = LogFactory.getLog(BookController.class);
	
	@Autowired
	@Qualifier("bookserviceimpl")
	private BookService serviceImpl;
	
	@GetMapping("/listBooks")
	public ModelAndView listAllBook(){
		log.info("CAll: " + "listAllBook()");
		ModelAndView view = new ModelAndView(BOOKPAGE);
		view.addObject("book", new BookStore());
		view.addObject("books", serviceImpl.listAllBook());
		return view;
		
	}
	@PostMapping("/addBook")
	public String addBook(@ModelAttribute("book") BookStore book ){
		log.info("Call: " + "addBook()" + "--Parametros--"+ book.toString());
		serviceImpl.addBook(book);
		return "redirect:/books/listBooks";
	}

}
