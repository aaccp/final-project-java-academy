package com.accentureacademy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.accentureacademy.model.Welcome;

@RestController
@RequestMapping("/welcome")
public class WelcomeController {

	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody Welcome createWelcome(@RequestParam(value="name", required=false, defaultValue="") String name){
		StringBuilder wMessage = new StringBuilder("Welcome");
		if(!name.isEmpty()){
			wMessage.append(", " + name);
		}
		wMessage.append("!");
		return new Welcome(wMessage.toString());
	}
}
