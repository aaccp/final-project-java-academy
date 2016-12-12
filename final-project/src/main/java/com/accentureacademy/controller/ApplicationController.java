package com.accentureacademy.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
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
public class ApplicationController{
	@Autowired
	private UserRepository repo;

    @RequestMapping(value="users", method=RequestMethod.POST)
    public User addUser(@RequestBody User user){
    	if(!alreadyExists(user))
    		return repo.saveAndFlush(user);
    	else
    		return user;
    }

    @RequestMapping(value="users", method=RequestMethod.GET)
	public List<User> usersList() {
		return repo.findAll();
	}

    @RequestMapping(value="users/{id}", method=RequestMethod.GET)
	public User getUser(@PathVariable Long id) {
		return repo.findOne(id);
	}

    @RequestMapping(value="users/{id}", method=RequestMethod.PUT)
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        User usr = repo.findOne(id);
        BeanUtils.copyProperties(user, usr);
        return repo.saveAndFlush(usr);
    }

    @RequestMapping(value="users/{id}", method=RequestMethod.DELETE)
    public User deleteUser(@PathVariable Long id) {
        User usr = repo.findOne(id);
        repo.delete(usr);
        return usr;
    }
    
    private boolean alreadyExists(User user){
    	List<User> users = this.usersList();
    	for(User usr: users){
    		if(usr.getName().compareTo(user.getName())==0)
    			return true;
    	}
    	return false;
    }
}
