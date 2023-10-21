package com.cache.service;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cache.entity.Book;
import com.cache.repo.BookRepo;



@Service
public class BookServiceImpl implements BookService{

	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
	@Autowired
	BookRepo bookRepo;
	
	public Book createBook(Book book) {
		logger.info("adding book with id - {}", book.getId());
		return bookRepo.save(book);
	}


	@Cacheable(cacheNames = "books", key="#id")
	public Book getBook(long id) {
		logger.info("fetching book from db");
		 Optional<Book> book=bookRepo.findById(id);
			if(book.isPresent()) {
				return book.get();
			}
			else {
		   return new Book();	
		}
	     }
	     public List<Book> getAllBook() {
	 		
	 		return bookRepo.findAll();
	 	}
   
     
 
	@Override
	@CachePut(cacheNames = "books", key="#book.id")
	public Book updateBook(Book book) {
		
		 bookRepo.updateBook(book.getId(), book.getName());
	        logger.info("book updated with new name");
	        return book;
	}

	  @Override
	    @CacheEvict(cacheNames = "books", key = "#id")
	    public String deleteBook(long id) {
	        bookRepo.deleteById(id);
	        return "Book deleted";
	    }


	}

