package com.accentureacademy;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class WelcomeControllerTest {

	private final String USER = "Bob";
	
    @Autowired
    private TestRestTemplate template;

    @Test
    public void getWelcomeMessage() throws Exception {
        ResponseEntity<String> response = template.getForEntity("/welcome",
                String.class);
        assertThat(response.getBody(), containsString("Welcome!"));
    }
    
    @Test
    public void getCustomWelcomeMessage() throws Exception{
    	String path = "/welcome?name=" + USER;
    	ResponseEntity<String> response = template.getForEntity(path ,
                String.class);
        assertThat(response.getBody(), containsString("Welcome, " + USER + "!"));
    }
}
