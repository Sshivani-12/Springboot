package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Customer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    // that's it ... no need to write any code LOL!

	//add a method to sort by last name
	//JPA buildin method
	public List<Customer> findAllByOrderByLastNameAsc();
}
