package com.example.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
//this is where we add all our related advices for logging
//lets start withan @Before advice

	// Now here it will just call addAccount from AccountDAO and not from
	// MembershipDAO.
	// @Before("execution(public void
	// com.example.demo.dao.AccountDAO.addAccount())")

	// Now here it will call addAccount from both AccountDAO and MembershipDAO.
	// @Before("execution(public void addAccount())")

	// Now here it will just call all nmethod which have add* in there method name from any class.
	//@Before("execution(public void add*())")
	
	//modifier public is not mandatory , now match on return type of void with add*
	//@Before("execution(void add*())")
	
	//match on return type of void with *add*, method with any return type will not be printed
	//@Before("execution(* add*())")
		

	//match on return type of void with *add*, method with any return type will not be printed
	//@Before("execution(* add*())")
	
	//match on return type of void with *add*, method with any return type will not be printed
	// .. means any number of arguments
	//@Before("execution(* add*(..))")
		
	
	// .. means any number of arguments
	//.* -> any class .*->any method
		@Before("execution(* com.example.demo.dao.*.*(..))")
		public void beforeAddAccountAdvice() {
		System.out.print("\n======>>>Executed @Befoere advice on method");
	}
}
