package com.accentureacademy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.accentureacademy.model.User;
import com.accentureacademy.repository.UserRepository;

@RestController
@SessionAttributes("user")
@RequestMapping("api/v1/")
public class ApplicationController {
	
	@Autowired
	private UserRepository repo;

	@RequestMapping("/welcome")
	public String welcome(@RequestParam(value="name", required=false, defaultValue="") String name) {
		StringBuilder wMessage = new StringBuilder("Welcome");
		if(name != null && !name.isEmpty()){
			wMessage.append(", ");
			wMessage.append(name);
		}
		wMessage.append("!");
		return wMessage.toString();
	}

    @RequestMapping(value= "users", method= RequestMethod.POST)
    public User addUser(@RequestBody User user){
    	return repo.saveAndFlush(user);
    }

    @RequestMapping(value= "users/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable Long id) {
		return repo.findOne(id);
	}

    @RequestMapping(value = "users", method = RequestMethod.GET)
	public List<User> usersList() {
		return repo.findAll();
	}
}
