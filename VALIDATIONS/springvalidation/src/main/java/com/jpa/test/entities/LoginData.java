package com.jpa.test.entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class LoginData {
	
	@NotBlank(message = "user name cant be null")
	@Size(min=3,max=12,message = "length 3 to 12")
	private String username;
	
	@Pattern(regexp = "/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$/;",message="Invalid Email!")
	private String email;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	@Override
	public String toString() {
		return "LoginData [username=" + username + ", email=" + email + "]";
	}


	public LoginData() {
		super();
		this.username = username;
		this.email = email;
	}
}
