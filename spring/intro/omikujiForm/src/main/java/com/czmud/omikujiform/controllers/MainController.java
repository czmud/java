package com.czmud.omikujiform.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.czmud.omikujiform.Omikuji;

@Controller
@RequestMapping("/omikuji")
public class MainController {
	@RequestMapping("")
	public String index() {
		return "index.jsp";
	}
	@PostMapping("/submit-fortune-form")
	public String submitFortuneForm(HttpSession session,
				@RequestParam(value="years") Integer years,
				@RequestParam(value="city") String city,
				@RequestParam(value="person") String person,
				@RequestParam(value="profession") String profession,
				@RequestParam(value="animal") String animal,
				@RequestParam(value="statement") String statement) {
		
		session.setAttribute("omikuji", new Omikuji( years, city, person, profession, animal, statement ));
		
		return "redirect:/omikuji/show";
	}
	@RequestMapping("/show")
	public String showFortune(Model model, HttpSession session) {
		model.addAttribute("omikuji", session.getAttribute("omikuji"));
		return "showfortune.jsp";
	}
	
}
