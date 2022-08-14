package com.czmud.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.czmud.bookclub.models.Book;
import com.czmud.bookclub.repositories.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
	
	public Book getBookById( Long id ) {
		Optional<Book> checkForBook = bookRepository.findById( id );
		if( checkForBook.isEmpty() ) {
			return null;
		}
		return checkForBook.get();
	}
	
	public Book createNewBook( Book book ) {
		return bookRepository.save( book );
	}
	
	public Book updateBook( Book editBook, BindingResult bindingResult ) {
		
		Optional<Book> checkForBook = bookRepository.findById( (Long) editBook.getId() );
		if( checkForBook.isEmpty() ) {
			bindingResult.rejectValue("id", "BadPostId", "Post id does not match existing post");
			return null;
		}
		
		Book confirmBookUserId = checkForBook.get();
		
		if ( !confirmBookUserId.getUser().getId().equals(editBook.getUser().getId()) ) {
			bindingResult.rejectValue("user", "BadUserId", "User does not match user id for post");
			return null;
		}
		
		
		
		return bookRepository.save( editBook );
	}

}
