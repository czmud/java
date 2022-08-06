package com.czmud.daikichiroutes.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/daikichi")
public class DaikichiController {
	@RequestMapping("")
	public String index() {
		return "Welcome!";
	}
	@RequestMapping("/today")
	public String today() {
		return "Today you will find luck in all your endeavors";
	}
	@RequestMapping("/tomorrow")
	public String tomorrow() {
		return ("Tomorrow, an opportunity will arise, so be sure to be open to"
				+ "new ideas!");
	}
	@RequestMapping("/travel")
	public String travel() {
		String destination = "Timbuktu";
		return String.format("Congratulations! You will soon travel to %s", destination);
	}
	@RequestMapping("/travel/{destination}")
	public String travel(@PathVariable(value="destination", required=false) String destination) {
		return String.format("Congratulations! You will soon travel to %s", destination);
	}
	@RequestMapping("/lotto/{inputNumber}")
	public String lotto(@PathVariable(value="inputNumber") String inputNumber ) {
		int inputNum = Integer.parseInt(inputNumber);
		if ( inputNum % 2 == 0 ) {
			return "You will take a grand journey in the near future, but be weary of tempting offers";
		}
		return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends."; 
	}

}
