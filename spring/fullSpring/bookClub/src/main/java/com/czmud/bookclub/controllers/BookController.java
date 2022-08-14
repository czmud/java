package com.czmud.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.czmud.bookclub.models.Book;
import com.czmud.bookclub.services.BookService;
import com.czmud.bookclub.services.UserService;

@Controller
@RequestMapping("/books")
public class BookController {
	@Autowired
	private BookService bookService;
	@Autowired
	private UserService userService;
	
	@GetMapping("")
	public String booksHome(Model model,
							HttpSession session) {
		
		if( session.getAttribute("userId") == null ) {
			session.invalidate();
			return "redirect:/";
		}
		
		model.addAttribute("user", userService.getUserById( (Long) session.getAttribute("userId") ));
		
		model.addAttribute("books", bookService.getAllBooks() );
		
		return "bookshome.jsp";
	}
	
	@GetMapping("/new")
	public String newBookForm( Model model,
							   HttpSession session) {
		
		if( session.getAttribute("userId") == null ) {
			session.invalidate();
			return "redirect:/";
		}
		
		model.addAttribute("user", userService.getUserById( (Long) session.getAttribute("userId") ));
		model.addAttribute("newBook", new Book() );
		
		return "booknew.jsp";
	}
	
	@PostMapping("/create-new-book")
	public String createNewBook( @Valid @ModelAttribute("newBook") Book newBook,
								 BindingResult bindingResult ) {
		
		if( bindingResult.hasErrors() ) {
			return "booknew.jsp";
		}
		
		String bookId = bookService.createNewBook( newBook ).getId().toString();
		
		return "redirect:/books/"+bookId;
	}
	
	@GetMapping("/{bookId}")
	public String viewBook( @PathVariable("bookId") Long bookId,
							Model model,
							HttpSession session ) {
		
		if( session.getAttribute("userId") == null ) {
			session.invalidate();
			return "redirect:/";
		}
		
		model.addAttribute("user", userService.getUserById( (Long) session.getAttribute("userId") ));
		model.addAttribute("book", bookService.getBookById( bookId ));
		
		
		return "bookview.jsp";
	}
	
	@GetMapping("/edit/{bookId}")
	public String editBookForm( @PathVariable("bookId") Long bookId,
							Model model,
							HttpSession session ) {
		
		if( session.getAttribute("userId") == null ) {
			session.invalidate();
			return "redirect:/";
		}
		
		Book editBook = bookService.getBookById( bookId );
		
		
		if( !session.getAttribute("userId").equals( editBook.getUser().getId()) ) {
			return "redirect:/books/"+bookId;
		}
		
		model.addAttribute("user", userService.getUserById( (Long) session.getAttribute("userId") ));
		model.addAttribute("editBook", editBook);
		
		return "bookedit.jsp";
	}
	
	@PutMapping("/edit-book/{id}")
	public String updateBook( @Valid @ModelAttribute("editBook") Book editBook,
							BindingResult bindingResult,
							Model model,
							HttpSession session,
							@PathVariable("id") Long bookId) {
				
		if( !session.getAttribute("userId").equals( editBook.getUser().getId()) ) {
			return "redirect:/books/"+bookId;
		}
		
		if( bindingResult.hasErrors() ) {
			model.addAttribute("user", userService.getUserById( (Long) session.getAttribute("userId") ));
			return "bookedit.jsp";
		}
		
		bookService.updateBook( editBook, bindingResult );
		
		if( bindingResult.hasFieldErrors( "user" ) ) {
			return "redirect:/users/log-user-out";
		}
		
		if( bindingResult.hasFieldErrors( "id" ) ) {
			return "redirect:/books";
		}
		
		
		return "redirect:/books/"+bookId;
	}
	
	
}
