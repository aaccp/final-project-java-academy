package com.accentureacademy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String hobbies;
	
	protected User(){}
	
	public User(String name){
		this.name = name;
	}
	
	public User(String name, String hobbies){
		this.name = name;
		this.hobbies = hobbies;
	}

	public String getHobbies() {
		return hobbies;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
    public String toString() {
        return String.format(
                "User[id=%d, name='%s', hobbies='%s']",
                id, name, hobbies);
    }
	
}
