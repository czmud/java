package com.czmud.ninjagold.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.czmud.ninjagold.models.Activity;
import com.czmud.ninjagold.models.Cave;
import com.czmud.ninjagold.models.Farm;
import com.czmud.ninjagold.models.House;
import com.czmud.ninjagold.models.Quest;
import com.czmud.ninjagold.models.Spa;

@Controller
public class MainController {
	@RequestMapping("/gold")
	public String index(Model model, HttpSession session) {
		if( session.getAttribute("goldTotal") == null ) {
			session.setAttribute("goldTotal", 0);
			session.setAttribute("activityLog", new ArrayList<Activity>());
		}
		model.addAttribute("goldTotal", session.getAttribute("goldTotal"));
		model.addAttribute("activityLog", session.getAttribute("activityLog"));
		return "index.jsp";
	}
	
	@PostMapping("/find-gold")
	public String findGold(HttpSession session,
				@RequestParam(value="activityChar") char activityChar) {
		
		@SuppressWarnings("unchecked")
		ArrayList<Activity> activityLog = (ArrayList<Activity>) session.getAttribute("activityLog");
		
		// switch statement to determine which new completed activity to add to activity log
		switch(activityChar) {
		case 'f':
			activityLog.add(new Farm());
			break;
		case 'c':
			activityLog.add(new Cave());
			break;
		case 'h':
			activityLog.add(new House());
			break;
		case 'q':
			activityLog.add(new Quest());
			break;
		case 's':
			activityLog.add(new Spa());
			break;
		}
		
		// save updated activity log back into session
		session.setAttribute("activityLog", activityLog );
		
		// update gold total based on new completed activity
		int goldEarned = activityLog.get(activityLog.size()-1).getGoldEarned();
		session.setAttribute("goldTotal", (int) session.getAttribute("goldTotal") + goldEarned);
		
		return "redirect:/gold";
	}
	@RequestMapping("/reset-gold")
	public String resetGold(HttpSession session) {
		session.setAttribute("goldTotal", 0);
		session.setAttribute("activityLog", new ArrayList<Activity>());
		return "redirect:/gold";
	}
	
	
}
