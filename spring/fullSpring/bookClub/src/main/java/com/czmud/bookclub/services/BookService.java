package com.czmud.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.czmud.bookclub.models.Book;
import com.czmud.bookclub.models.User;
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
	
	public Book borrowBookToBorrower( Long bookId, User borrower ) {

		Optional<Book> checkForBook = bookRepository.findById( bookId );
		if( checkForBook.isEmpty() ) {
			return null;
		}
		
		Book borrowBook = checkForBook.get();
		
		if( borrowBook.isBorrowed() ) {
			return null;
		}
		
		borrowBook.setBorrower( borrower );
		
		
		
		return bookRepository.save( borrowBook );
	}
	
	public Book returnBookToOwner( Long bookId, Long borrowerId) {
		
		Optional<Book> checkForBook = bookRepository.findById( bookId );
		if( checkForBook.isEmpty() ) {
			return null;
		}
		
		Book returnBook = checkForBook.get();
		
		if( !returnBook.getBorrower().getId().equals(borrowerId) ) {
			return null;
		}
		
		returnBook.setBorrower( returnBook.getUser());
		
		return bookRepository.save( returnBook );
	}
	
	public void deleteBookById( Long bookId, Long userId ) {
		
		Optional<Book> checkForBook = bookRepository.findById( bookId );
		if( checkForBook.isEmpty() ) {
			return;
		}
		
		Book deleteBook = checkForBook.get();
		
		if( ! deleteBook.getUser().getId().equals(userId) ) {
			return;
		}
		
		bookRepository.deleteById( bookId );
		
		return;
	}
	
	
	
	
}
