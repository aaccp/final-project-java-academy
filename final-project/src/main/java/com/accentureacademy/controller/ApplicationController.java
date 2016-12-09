package com.accentureacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {

	@RequestMapping("/welcome")
	public String welcome(@RequestParam(value="name", required=false, defaultValue="") String name, Model model) {
		StringBuilder wMessage = new StringBuilder("Welcome");
		if(name != null && !name.isEmpty()){
			wMessage.append(", ");
			wMessage.append(name);
		}
		wMessage.append("!");
		model.addAttribute("message", wMessage.toString());
		return "welcome";
	}

}
