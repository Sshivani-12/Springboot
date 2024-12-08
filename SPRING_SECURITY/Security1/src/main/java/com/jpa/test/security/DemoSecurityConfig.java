package com.jpa.test.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig
{
//we can add our own users and pass through memory user
	/*
	 * @Bean public InMemoryUserDetailsManager userDetailsManager() { //noop plain text password
	 * UserDetails john = User.builder().username("john").password("{noop}123").roles("EMPLOYEE").build
	 * (); return new InMemoryUserDetailsManager(john);
	 * 
	 * }
	 */
	// add support for JDBC
	/*
	 * @Bean public UserDetailsManager userDetailManager(DataSource dataSource) { return new
	 * JdbcUserDetailsManager(dataSource); }
	 */

	// custom table
	@Bean
	public UserDetailsManager userDetailManager(DataSource dataSource)
	{
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

		// define query to retrive a user by username
		jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id from members where user_id=?");

		// define query to retrive a user by username
		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id,roles from roles where user_id=?");

		return jdbcUserDetailsManager;
	}

	@Bean
	public SecurityFilterChain filterchain(HttpSecurity http) throws Exception
	{
		http.authorizeHttpRequests(configurer -> 
		configurer.requestMatchers(HttpMethod.GET, "/api/employees")
		.hasRole("EMPLOYEE")
		.requestMatchers(HttpMethod.GET, "/api/employees/**")
		.hasRole("EMPLOYEE").requestMatchers(HttpMethod.POST, "/api/employees")
		.hasRole("MANAGER").requestMatchers(HttpMethod.PUT, "/api/employees")
		.hasRole("MANAGER").requestMatchers(HttpMethod.DELETE, "/api/employees/**")
		.hasRole("ADMIN"));
		// use HTTP Basic authentication
		http.httpBasic(Customizer.withDefaults());

		// disable cross site request forgery (CSRF)
		// in general not required for stateless REST API
		http.csrf(csrf -> csrf.disable());
		return http.build();
	}
}
