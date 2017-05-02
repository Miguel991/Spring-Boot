package com.hmc.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hmc.entity.BookStore;


@Repository("bookRepository")
public interface BookJPARepository extends JpaRepository<BookStore, Serializable> {
	
	public abstract BookStore findByPrice(int price);
	
	public abstract BookStore findByTitle(String title);
	
	public abstract BookStore findByTitleAndAuthor(String title,String author);

}
