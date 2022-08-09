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
		int goldEarned = 0; 
		
		@SuppressWarnings("unchecked")
		ArrayList<Activity> activityLog = (ArrayList<Activity>) session.getAttribute("activityLog");
		
		switch(activityChar) {
		case 'f':
			activityLog.add(new Farm());
			goldEarned = activityLog.get(activityLog.size()-1).getGoldEarned();
			session.setAttribute("activityLog", activityLog );
			break;
		case 'c':
			activityLog.add(new Cave());
			goldEarned = activityLog.get(activityLog.size()-1).getGoldEarned();
			session.setAttribute("activityLog", activityLog );
			break;
		case 'h':
			activityLog.add(new House());
			goldEarned = activityLog.get(activityLog.size()-1).getGoldEarned();
			session.setAttribute("activityLog", activityLog );
			break;
		case 'q':
			activityLog.add(new Quest());
			goldEarned = activityLog.get(activityLog.size()-1).getGoldEarned();
			session.setAttribute("activityLog", activityLog );
			break;
		case 's':
			activityLog.add(new Spa());
			goldEarned = activityLog.get(activityLog.size()-1).getGoldEarned();
			session.setAttribute("activityLog", activityLog );
			break;
		}
		
		
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
