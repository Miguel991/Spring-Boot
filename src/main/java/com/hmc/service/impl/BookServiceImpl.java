package com.hmc.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hmc.entity.BookStore;
import com.hmc.repository.BookJPARepository;
import com.hmc.service.BookService;


@Service("bookserviceimpl")
public class BookServiceImpl implements BookService {
	
	private static final Log log = LogFactory.getLog(BookServiceImpl.class);

	@Autowired
	@Qualifier("bookRepository")
	private BookJPARepository repository;
	
	
	@Override
	public List<BookStore> listAllBook() {
		log.info("Se llamo al metood: "+"listaAllBook()");
		return repository.findAll();
		
	}

	@Override
	public BookStore addBook(BookStore book) {
		log.info("Se llamo al metood: "+"addBook()");
		return repository.save(book);
		
	}

	@Override
	public int removeBook(int id) {
		log.info("Se llamo al metood: "+"removeBook()");
		repository.delete(id);
		return 0;
	}

	@Override
	public BookStore updateBook(BookStore book) {
		log.info("Se llamo al metood: "+"updateBook()");
		return repository.save(book);
	}

}
