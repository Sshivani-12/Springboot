package com.example.demo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {
	@Override
	public void addActionMember() {
		System.out.print(getClass() + "DOING MY DB WORK");
	}

	@Override
	public boolean addSillyMember() {
		System.out.print(getClass() + "DOING MY DB WORK");
		return false;
	}

	@Override
	public void goToASleep() {
		System.out.print(getClass() + "SLEPPYING NOW");
		
	}

}
