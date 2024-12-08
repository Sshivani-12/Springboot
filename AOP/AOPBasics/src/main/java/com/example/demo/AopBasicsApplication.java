package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.dao.AccountDAO;
import com.example.demo.dao.MembershipDAO;

@SpringBootApplication
public class AopBasicsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopBasicsApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		return runner -> {
			demoTheBeforAdvicee(theAccountDAO, theMembershipDAO);
		};
	}

	private void demoTheBeforAdvicee(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		// call the business method
		//theAccountDAO.addAccount();

		// call the business method again
		//theAccountDAO.addAccount();

		
		// call the membership business method
		//theMembershipDAO.addAccount();
		
		// call the business method again
		/*Account myAccount=new Account();
		theAccountDAO.addAccount(myAccount);
*/
		Account myAccount=new Account();
		theAccountDAO.addAccount(myAccount,true);
		theAccountDAO.doWork();
		
		theMembershipDAO.addSillyMember();
		theMembershipDAO.addActionMember();
		theMembershipDAO.goToASleep();
		
		
		
	}
}
