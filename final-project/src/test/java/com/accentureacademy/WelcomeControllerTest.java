package com.accentureacademy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.accentureacademy.controller.WelcomeController;
import com.accentureacademy.model.Welcome;
import com.accentureacademy.repository.UserRepository;

public class WelcomeControllerTest {

	private final String USER = "Bob";
    
    @InjectMocks
    private WelcomeController ac;
    
    @Mock
    private UserRepository mock;
	
	@Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getWelcomeMessage() throws Exception {
    	Welcome welcome = ac.createWelcome("");
    	assertThat(welcome.getwMessage(), equalTo("Welcome!"));
    }
    
    @Test
    public void getCustomWelcomeMessage() throws Exception{
    	Welcome welcome = ac.createWelcome(USER);
    	assertThat(welcome.getwMessage(), equalTo("Welcome, " + USER + "!"));
    }
}
