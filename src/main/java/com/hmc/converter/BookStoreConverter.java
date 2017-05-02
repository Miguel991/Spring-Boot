package com.hmc.converter;

import org.springframework.stereotype.Component;

import com.hmc.entity.BookStore;
import com.hmc.model.BookModel;

@Component("bookConverter")
public class BookStoreConverter {
	
	//entity a model
	public BookModel entityToModel(BookStore book){
		BookModel model = new BookModel();
		model.setAuthor(book.getAuthor());
		model.setTitle(book.getTitle());
		model.setPrice(book.getPrice());
		
		return model;
	}
	
	
	//model a entity
	public BookStore modelToEntity(BookModel model){
		BookStore store = new BookStore();
		store.setAuthor(model.getAuthor());
		store.setPrice(model.getPrice());
		store.setTitle(model.getTitle());
		
		return store;
		
	}

}
