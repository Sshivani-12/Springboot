package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Repository;

import com.example.demo.Account;

@Repository
public class AccountDAOImp implements AccountDAO {

	private String name;

	private String serviceCode;

	public String getName() {
		System.out.print(getClass() + "name");
		return name;
	}

	public void setName(String name) {
		System.out.print(getClass() + "name");

		this.name = name;
	}

	public String getServiceCode() {
		System.out.print(getClass() + "ServiceCode");

		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.print(getClass() + "ServiceCode");

		this.serviceCode = serviceCode;
	}

	@Override
	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.print(getClass() + "DOING MY DB WORK");
	}

	@Override
	public boolean doWork() {
		System.out.print(getClass() + "doWork()");

		return false;
	}

	@Override
	public List<Account> findAccounts() {

		return findAccounts(false);
	}

	@Override
	public List<Account> findAccounts(boolean tripWire) {

		if(tripWire==true)
		{
			throw new RuntimeException("No soup for you!!!");
		}
		List<Account> myAccount = new ArrayList<>();

		// create sample accounts
		Account temp1 = new Account("John", "Silver");
		Account temp2 = new Account("Madhu", "Platinum");
		Account temp3 = new Account("Luca", "Gold");

		// add them to our accounts list
		myAccount.add(temp1);
		myAccount.add(temp2);
		myAccount.add(temp3);

		return myAccount;
	}
}
