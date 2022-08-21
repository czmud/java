package com.czmud.languages.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.czmud.languages.models.Language;
import com.czmud.languages.services.LanguageService;

@Controller
@RequestMapping("languages")
public class LanguageController {
	@Autowired
	private LanguageService languageService;
	
	@GetMapping("")
	public String languageDashboard( @ModelAttribute("newLanguage") Language newLanguage,
									 Model model) {
		
		model.addAttribute("languages", languageService.getAllLanguages() );
		
		return "languagedashboard.jsp";
	}
	
	@PostMapping("/create-new-language")
	public String createNewLanguage( @Valid @ModelAttribute("newLanguage") Language newLanguage,
								     BindingResult bindingResult, Model model ) {
		
		if( bindingResult.hasErrors() ) {
			model.addAttribute("languages", languageService.getAllLanguages() );
			return "languagedashboard.jsp";
		}
		
		Language createdLanguage = languageService.createNewLanguage( newLanguage, bindingResult );
		
		String languageId = createdLanguage.getId().toString();
		
		return "redirect:/languages/"+languageId;
	}
	
	@GetMapping("/{languageId}")
	public String languageView( @PathVariable("languageId") Long languageId,
								Model model) {
		
		model.addAttribute("language", languageService.getLanguageById( languageId ) );
		
		return "languageview.jsp";
	}
	
	@GetMapping("/edit/{languageId}")
	public String languageEdit( @PathVariable("languageId") Long languageId,
								Model model) {
		
		model.addAttribute("editLanguage", languageService.getLanguageById( languageId ) );
		
		return "languageedit.jsp";
	}
	
	@PutMapping("/edit-language/{id}")
	public String updateLanguage( @Valid @ModelAttribute("editLanguage") Language editLanguage,
								  BindingResult bindingResult, Model model,
								  @PathVariable("id") Long languageId) {
		
		if( bindingResult.hasErrors() ) {
			System.out.println( bindingResult.getModel() );
			return "languageedit.jsp";
		}
		
		languageService.updateLanguage( editLanguage, bindingResult );
		
		if( bindingResult.hasFieldErrors( "id" ) ) {
			return "redirect:/languages";
		}
		
		return "redirect:/languages/"+languageId;
	}
	
	@DeleteMapping("/delete-language/{languageId}")
	public String destroyLanguage( @PathVariable("languageId") Long languageId ) {
		
		languageService.deleteLanguageById( languageId );
		
		return "redirect:/languages";
	}
	
	
	
}
