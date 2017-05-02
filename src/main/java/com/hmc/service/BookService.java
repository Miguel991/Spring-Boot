package com.hmc.service;

import java.util.List;

import com.hmc.entity.BookStore;

public interface BookService {
	
	public abstract List<BookStore> listAllBook();
	public abstract BookStore addBook(BookStore book);
	public abstract int removeBook(int id);
	public abstract BookStore updateBook(BookStore book);

}
