package com.czmud.hellohuman.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HumanController {
	@RequestMapping("/")
	public String index(@RequestParam(value="f", defaultValue="human", required=false) String firstName,
						@RequestParam(value="l", defaultValue="", required=false) String lastName,
						@RequestParam(value="t", defaultValue="1", required=false) String times) {
		String returnString = new String();
		int loopTimes = Integer.parseInt(times);
		for (int i = 0; i<loopTimes; i++ ) {
			returnString += String.format("<p>Hello %s %s</p>", firstName, lastName );
		}
		return returnString;
	}
}
