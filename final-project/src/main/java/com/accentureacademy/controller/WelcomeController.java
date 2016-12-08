package com.accentureacademy.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@RequestMapping("/welcome")
	public String welcome(@RequestParam(value="name", required=false, defaultValue="") String name, Model model) {
		model.addAttribute("name", name);
		StringBuilder wMessage = new StringBuilder("Welcome");
		if(name != null && !name.isEmpty()){
			wMessage.append(", ");
			wMessage.append(name);
		}
		wMessage.append("!");
		return wMessage.toString();
	}

}
