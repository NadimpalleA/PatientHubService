package com.cache.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cache.entity.Book;
import com.cache.service.BookServiceImpl;

@RestController
@RequestMapping("cache")
class BookController {

    @Autowired
	BookServiceImpl bookService;
    
    
    @PostMapping("/create")
    public Book createBook(@RequestBody Book book) {
    	
    	return bookService.createBook(book);
    }
    
    @GetMapping("/get/{id}")
	public Book getBook(@PathVariable("id") long id) {
    	
    	return bookService.getBook(id);
    }
    
    @GetMapping("/getAll/{id}")
    public List<Book> getAllBook( ){
    	
    	return bookService.getAllBook();
    	
    }
    @PutMapping("/book")
    public Book updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }
	
	
    @DeleteMapping("/delete")
    public void deleteBook(@PathVariable("id") long id) {
    	
    	bookService.deleteBook(id);
    }
	
	
	
}
