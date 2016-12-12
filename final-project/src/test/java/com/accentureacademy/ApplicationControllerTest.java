package com.accentureacademy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.accentureacademy.controller.ApplicationController;
import com.accentureacademy.model.User;
import com.accentureacademy.repository.UserRepository;

public class ApplicationControllerTest {
    
    @InjectMocks
    private ApplicationController ac;
    
    @Mock
    private UserRepository mock;
	
	@Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void addUserToDB(){
		User user = new User("1", "A");
		ac.addUser(user);
		
		verify(mock).saveAndFlush(user);
	}
	
	@Test
	public void getUserFromDB(){
		Long id = 1l;
		User user = new User();
    	user.setId(id);
		when(mock.findOne(id)).thenReturn(user);

		User usr = ac.getUser(id);

		verify(mock).findOne(id);
		assertThat(usr.getId(), equalTo(id));
	}
	
	@Test
	public void getListOfUsers(){
		List<User> users = Arrays.asList(new User("A"), new User("B"));
		when(mock.findAll()).thenReturn(users);
		
		List<User> aux = ac.usersList();
		
		verify(mock).findAll();
		assertThat(aux.get(0).getName(), equalTo("A"));
	}
    	
}
