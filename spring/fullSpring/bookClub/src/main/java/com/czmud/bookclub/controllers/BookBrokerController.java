package com.czmud.bookclub.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.czmud.bookclub.models.User;
import com.czmud.bookclub.services.BookService;
import com.czmud.bookclub.services.UserService;

@Controller
@RequestMapping("/bookmarket")
public class BookBrokerController {
	@Autowired
	private BookService bookService;
	@Autowired
	private UserService userService;
	
	
	@GetMapping("")
	public String viewBookMarket( Model model, HttpSession session ) {
		
		if( session.getAttribute("userId") == null ) {
			session.invalidate();
			return "redirect:/";
		}
		
		model.addAttribute("user", userService.getUserById( (Long) session.getAttribute("userId") ));
		model.addAttribute("books", bookService.getAllBooks() );
		
		return "bookbroker.jsp";
	}
	
	@PutMapping("/borrow/{bookId}")
	public String updateBookBorrower( @PathVariable("bookId") Long bookId,
									  Model model, HttpSession session ) {
		
		
		User borrower = userService.getUserById( (Long) session.getAttribute("userId"));
		
		
		bookService.borrowBookToBorrower(bookId, borrower);
		
		
		
		return "redirect:/bookmarket";
		
	}
	
	@PutMapping("/return/{bookId}")
	public String updateBookReturnToOwner( @PathVariable("bookId") Long bookId,
									  	   Model model, HttpSession session ) {
		
		
		bookService.returnBookToOwner(bookId, (Long) session.getAttribute("userId"));
		
		
		
		return "redirect:/bookmarket";
		
	}
	
	
}
