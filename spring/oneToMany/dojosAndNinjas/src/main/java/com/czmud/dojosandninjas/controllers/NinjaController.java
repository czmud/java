package com.czmud.dojosandninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.czmud.dojosandninjas.models.Ninja;
import com.czmud.dojosandninjas.services.DojoService;
import com.czmud.dojosandninjas.services.NinjaService;

@Controller
@RequestMapping("/ninjas")
public class NinjaController {
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	
	
	public NinjaController( DojoService dojoService,
							NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	
	
	
	
	@GetMapping("/new")
	public String newNinjaForm(@ModelAttribute("ninja") Ninja ninja,
								Model model) {
		
		model.addAttribute("dojos", dojoService.getAllDojos());
		
		return "ninjaform.jsp";
	}
	@PostMapping("/create-new-ninja")
	public String createNewNinja( @Valid @ModelAttribute("ninja") Ninja ninja,
									BindingResult bindingResult,
									Model model ) {
		
		if( bindingResult.hasErrors() ) {
			model.addAttribute("dojos", dojoService.getAllDojos());
			return "ninjaform.jsp";
		}
		
		System.out.print(ninja.getDojo().getId());
		
		ninjaService.createNinja( ninja );
		
		String dojoId = ninja.getDojo().getId().toString();
		
		return "redirect:/dojos/"+dojoId;
	}

}
