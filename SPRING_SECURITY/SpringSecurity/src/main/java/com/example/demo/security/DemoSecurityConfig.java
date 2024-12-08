package com.example.demo.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig
{

	//Add support for JDBC /...no more hardcorded users
	/*@Bean
	public UserDetailsManager userDetailManager(DataSource dataSource)
	{
		return new JdbcUserDetailsManager(dataSource);
	}
	*/
	
	//CUSTOM TABLE CODE IN JDBC
	@Bean
	public UserDetailsManager userDetailManager(DataSource dataSource)
	{
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
		
		//DEFINE QUERY TO RETRIVEE A USER BY USERNAME
		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
				"select user_id,pw,active from members where user_id=?"
				);
		
		//DEFINE QUERY TO RETRIVE THE AUTHORITIES/ROLES BY USERNAME

		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
				"select user_id,role from roles where user_id=?"
				);
		return jdbcUserDetailsManager;
	}
	
	@Bean
	public SecurityFilterChain filterchain(HttpSecurity http) throws Exception
	{
		//logout the user
		http.authorizeHttpRequests(configurer -> 
		configurer.requestMatchers("/").hasAnyRole("EMPLOYEE")
		.requestMatchers("/leaders/**").hasAnyRole("MANAGER")
		.requestMatchers("/systems/**").hasAnyRole("ADMIN").anyRequest()
		.authenticated())
		.formLogin(form -> 
		form.loginPage("/showMyLoginPage")
		.loginProcessingUrl("/authenticateTheUser")
		.permitAll())
		.logout(layout->layout.permitAll())
		.exceptionHandling(config->config.accessDeniedPage("/acess-denied"));
		
		return http.build();
	}

	/*
	 //we can add our own users and pass through memory user
	 

		@Bean
		public InMemoryUserDetailsManager userDetailsManager()
		{ // noop plain text password
			UserDetails john = User.builder().username("john").password("{noop}test123").roles("EMPLOYEE").build();

			UserDetails shivani = User.builder().username("shivani").password("{noop}123").roles("EMPLOYEE", "MANAGER", "ADMIN").build();

			return new InMemoryUserDetailsManager(john, shivani);

		}
	*/
		// custom login code
		/*@Bean
		public SecurityFilterChain filterchain(HttpSecurity http) throws Exception
		{
			//logout the user
			http.authorizeHttpRequests(configurer -> configurer.anyRequest().authenticated()).formLogin(form -> form.loginPage("/showMyLoginPage").loginProcessingUrl("/authenticateTheUser").permitAll()).logout(layout->layout.permitAll());
			// use HTTP Basic authentication
			http.httpBasic(Customizer.withDefaults());

			// disable cross site request forgery (CSRF)
			// in general not required for stateless REST API
			http.csrf(csrf -> csrf.disable());
			return http.build();
		}

	*/
}
