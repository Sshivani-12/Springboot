package com.jpa.test.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoSecurityConfig
{
//we can add our own users and pass through memory user

	@Bean
	public InMemoryUserDetailsManager userDetailsManager()
	{ // noop plain text password
		UserDetails john = User.builder()
				.username("john")
				.password("{noop}test123")
				.roles("EMPLOYEE")
				.build();
		
		UserDetails shivani = User.builder()
				.username("shivani")
				.password("{noop}123")
				.roles("EMPLOYEE","MANAGER","ADMIN")
				.build();
		
		
		return new InMemoryUserDetailsManager(john,shivani);

	}

}