package com.czmud.bookclub.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.czmud.bookclub.models.LoginUser;
import com.czmud.bookclub.models.User;
import com.czmud.bookclub.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public User createNewUser( User newUser, BindingResult result ) {
		
		Optional<User> checkForUser = userRepository.findByEmail( newUser.getEmail() );
		if( checkForUser.isPresent() ) {
			result.rejectValue("email", "Matches", "Account with same email already exists");
		}
		
		if( ! newUser.getPassword().equals(newUser.getConfirmPassword() )) {
			result.rejectValue("confirmPassword", "Matches", "password confirmation and password must match" );
		}
		
		if(result.hasErrors() ) {
			return null;
		}
		
		newUser.setPasswordHash( BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt()));
		
		return userRepository.save( newUser );
	}
	
	public User login( LoginUser newLoginUser, BindingResult result) {
		
		Optional<User> checkForUser = userRepository.findByEmail( newLoginUser.getEmail() );
		if( checkForUser.isEmpty() ) {
			result.rejectValue("email", "Matches", "Email not found");
			return null;
		}
		User user = checkForUser.get();
		
		if(!BCrypt.checkpw(newLoginUser.getPassword(), user.getPasswordHash() )) {
		    result.rejectValue("password", "Matches", "Invalid Password");
		}
		
		if(result.hasErrors()) {
		    return null;
		}
	
		return user;
	}
	
	public User getUserById( Long id ) {
		Optional<User> checkForUser = userRepository.findById( id );
		if( checkForUser.isEmpty() ) {
			return null;
		}
		
		return checkForUser.get();
	}

}
