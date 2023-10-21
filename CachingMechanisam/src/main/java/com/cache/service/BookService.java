package com.cache.service;

import com.cache.entity.Book;

public interface BookService {
	
 Book createBook(Book book);
 Book getBook(long id);
 Book updateBook(Book book);
  String deleteBook(long id);
}
