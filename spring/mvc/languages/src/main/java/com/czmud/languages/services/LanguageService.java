package com.czmud.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.czmud.languages.models.Language;
import com.czmud.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	@Autowired
	private LanguageRepository languageRepository;
	
	public List<Language> getAllLanguages(){
		return languageRepository.findAll();
	}
	
	public Language getLanguageById( Long id ) {
		Optional<Language> checkForLanguage = languageRepository.findById( id );
		if( checkForLanguage.isEmpty() ) {
			return null;
		}
		return checkForLanguage.get();
	}
	
	public Language createNewLanguage( Language newLanguage, BindingResult bindingResult ) {		
		return languageRepository.save( newLanguage );
	}
	
	public Language updateLanguage( Language editLanguage, BindingResult bindingResult ) {
		
		Optional<Language> checkForLanguage = languageRepository.findById( (Long) editLanguage.getId() );
		if( checkForLanguage.isEmpty() ) {
			bindingResult.rejectValue("id", "BadLanguageId", "Language id does not match existing language");
			return null;
		}
			
		return languageRepository.save( editLanguage );
	}
	
	public void deleteLanguageById( Long languageId ) {
		
		Optional<Language> checkForLanguage = languageRepository.findById( languageId );
		if( checkForLanguage.isEmpty() ) {
			return;
		}
		
		languageRepository.deleteById( languageId );
		
		return;
	}
}
