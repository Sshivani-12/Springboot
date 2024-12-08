package com.example.demo.dao;

import org.springframework.stereotype.Repository;

import com.example.demo.Account;

@Repository
public class AccountDAOImp implements AccountDAO{

	/*@Override
	public void addAccount() {
		System.out.print(getClass()+"DOING MY DB WORK");
	}*/
	

	/*@Override
	public void addAccount(Account theAccount) {
		System.out.print(getClass()+"DOING MY DB WORK");
	}*/
	
	@Override
	public void addAccount(Account theAccount,boolean vipFlag) {
		System.out.print(getClass()+"DOING MY DB WORK");
	}

	@Override
	public boolean doWork() {
		System.out.print(getClass()+"doWork()");
		
		return false;
	}
}
