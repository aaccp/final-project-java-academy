package com.accentureacademy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accentureacademy.model.User;
import com.accentureacademy.repository.UserRepository;

@RestController
@RequestMapping("api/v1/")
public class ApplicationController {
	
	@Autowired
	private UserRepository repo;

    @RequestMapping(value="users", method=RequestMethod.POST)
    public User addUser(@RequestBody User user){
    	return repo.saveAndFlush(user);
    }

    @RequestMapping(value="users", method=RequestMethod.GET)
	public List<User> usersList() {
		return repo.findAll();
	}

    @RequestMapping(value="users/{id}", method=RequestMethod.GET)
	public User getUser(@PathVariable Long id) {
		return repo.findOne(id);
	}
}
