package com.accentureacademy;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.accentureacademy.model.User;
import com.accentureacademy.repository.UserRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest{

	@Autowired
	private UserRepository repo;
    
    @Test
    public void dbCanbeAccessed() throws Exception{
    	repo.save(new User("Mike Thompson","Soccer;Ping Pong"));
    	repo.save(new User("Art King", "Design"));
    	repo.save(new User("John Smith", "Music;"));
    	
    	List<User> users = repo.findAll();
    	assertThat(users.get(2).getName(), equalTo("John Smith"));
    	assertThat(users.get(0).getHobbies(), containsString("Ping Pong"));
    }
}