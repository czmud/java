package com.czmud.books.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.czmud.books.models.Book;
import com.czmud.books.services.BookService;

@RestController
public class BookApi {
	private final BookService bookService;
	
	public BookApi(BookService bookService){
		this.bookService = bookService;
	}
	
	// other methods removed for brevity
	@RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
	public Book update(
			@PathVariable("id") Long id,
			@RequestParam(value="title") String title, 
			@RequestParam(value="description") String desc, 
			@RequestParam(value="language") String lang,
			@RequestParam(value="pages") Integer numOfPages) {
		Book book = new Book(id, title, desc, lang, numOfPages);
		return bookService.updateBook(book);
	}
	
	@RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
	public void destroy(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
	}
}



