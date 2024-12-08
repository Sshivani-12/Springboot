package com.example.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.dao.AccountDAO;
import com.example.demo.dao.MembershipDAO;
import com.example.demo.service.TrafficFortuneService;

@SpringBootApplication
public class AopBasicsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopBasicsApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO,
			TrafficFortuneService thetrafficFortuneService) {
		return runner -> {
			// demoTheBeforAdvicee(theAccountDAO, theMembershipDAO);
			// demoTheAfterReturningAdvice(theAccountDAO);
			// demoTheAfterThrowingAdvice(theAccountDAO);
			// demoTheAfterAdvice(theAccountDAO);
			//demoTheAroundAdvice(thetrafficFortuneService);

			demoTheAroundAdviceHandleException(thetrafficFortuneService);
		};
	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService thetrafficFortuneService) {
		// display the accounts

		System.out.println("Calling demoTheAroundAdviceHandleException");
		
		boolean tripWise=true;
		
		String data = thetrafficFortuneService.getFortune(tripWise);
		System.out.println("Fininshed"+data);


	}

	private void demoTheAroundAdvice(TrafficFortuneService thetrafficFortuneService) {

		// display the accounts

		System.out.println("Calling getFortune");
		String data = thetrafficFortuneService.getFortune();
		System.out.println("Fininshed"+data);

	}

	private void demoTheAfterAdvice(AccountDAO theAccountDAO) {
		// call method to find accounts
		List<Account> theAccount = null;

		try {
			// add boolean flag to simulate exeptions
			boolean tripWire = true;
			theAccount = theAccountDAO.findAccounts(tripWire);
			theAccount = theAccountDAO.findAccounts();
		} catch (Exception e) {
			System.out.println("Exception" + e);

		}
		// display the accounts
		System.out.println("Main program:demoTheAfterReturningAdvice");

		System.out.println(theAccount);

	}

	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {

		// call method to find accounts
		List<Account> theAccount = null;

		try {
			// add boolean flag to simulate exeptions
			boolean tripWire = true;
			theAccount = theAccountDAO.findAccounts(tripWire);
			theAccount = theAccountDAO.findAccounts();
		} catch (Exception e) {
			System.out.println("Exception" + e);

		}
		// display the accounts
		System.out.println("Main program:demoTheAfterReturningAdvice");

		System.out.println(theAccount);

	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {

		// call method to find accounts
		List<Account> theAccount = theAccountDAO.findAccounts();

		// display the accounts
		System.out.println("Main program:demoTheAfterReturningAdvice");

		System.out.println(theAccount);
	}

	private void demoTheBeforAdvicee(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

		// call business method
		Account myAccount = new Account();
		myAccount.setName("name");
		myAccount.setLevel("level");

		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();

		// call the accountdao getter/setter
		theAccountDAO.setName("shivani");
		theAccountDAO.setServiceCode("silver");

		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();

		// calll the membership methods
		theMembershipDAO.addSillyMember();
		theMembershipDAO.addActionMember();
		theMembershipDAO.goToASleep();

	}
}
