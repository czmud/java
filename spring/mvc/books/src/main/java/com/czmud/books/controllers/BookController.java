package com.czmud.books.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.czmud.books.services.BookService;

@Controller
public class BookController {
	private final BookService bookService;
	
	public BookController(BookService bookService){
		this.bookService = bookService;
	}
	@GetMapping("/api/books")
	public String showAllBooks( Model model ) {
		model.addAttribute("books", bookService.allBooks());
		return "index.jsp";
	}
	
	@GetMapping("/api/books/{id}")
	public String showBook( Model model,
			@PathVariable("id") Long id) {
		
		model.addAttribute("books", bookService.findBookById( id ));
		
		return "showbook.jsp";
	}
}
