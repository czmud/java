package com.czmud.dojosandninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.czmud.dojosandninjas.models.Dojo;
import com.czmud.dojosandninjas.services.DojoService;

@Controller
@RequestMapping("/dojos")
public class DojoController {
	private final DojoService dojoService;
	
	public DojoController( DojoService dojoService ) {
		this.dojoService = dojoService;
	}
	
	@GetMapping("/new")
	public String newDojoForm( @ModelAttribute("dojo") Dojo dojo) {
		
		return "dojoform.jsp";
	}
	
	@PostMapping("/create-new-dojo")
	public String createNewDojo( @Valid @ModelAttribute("dojo") Dojo dojo,
								BindingResult bindingResult ) {
		
		if( bindingResult.hasErrors() ) {
			return "dojoform.jsp";
		}
		
		dojoService.createDojo( dojo );
		
		String id = dojo.getId().toString();
		
		return "redirect:/dojos/"+id;
	}
	
	@GetMapping("/{id}")
	public String showDojoWithNinjas( @PathVariable("id") Long id,
									Model model) {
		
		model.addAttribute("dojo", dojoService.getDojoById( id ));
		
		return "dojoshow.jsp";
	}
	
}
