package com.czmud.counter.controllers;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/your-server")
public class CounterController {
	@RequestMapping("")
	public String index(HttpSession session) {
		if ( session.getAttribute("visitCount") == null ) {
			session.setAttribute("visitCount", 1);
		} else {
			session.setAttribute("visitCount", ((Integer) session.getAttribute("visitCount") ) + 1);
		}		
		
		return "index.jsp";
	}
	
	@RequestMapping("/double-whammy")
	public String doubleWhammy(HttpSession session) {
		if ( session.getAttribute("visitCount") == null ) {
			session.setAttribute("visitCount", 2);
		} else {
			session.setAttribute("visitCount", ((Integer) session.getAttribute("visitCount") ) + 2);
		}		
		
		return "double.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter(HttpSession session, Model model) {
		if ( session.getAttribute("visitCount") == null ) {
			session.setAttribute("visitCount", 0);
		}
		
		model.addAttribute("visitCount", (Integer) session.getAttribute("visitCount") );
		
		return "counter.jsp";
	}
	
	@RequestMapping("/reset-counter")
	public String resetCounter(HttpSession session) {
		session.setAttribute("visitCount", 0);
		return "redirect:/your-server/counter";
	}

}
