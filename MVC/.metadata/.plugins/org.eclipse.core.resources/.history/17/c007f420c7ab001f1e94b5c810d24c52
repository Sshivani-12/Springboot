package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.CustomerRepository;
import com.luv2code.springboot.cruddemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository CustomerRepository;

	@Autowired
	public CustomerServiceImpl(CustomerRepository theCustomerRepository) {
		CustomerRepository = theCustomerRepository;
	}

	@Override
	public List<Customer> findAll() {
		// return CustomerRepository.findAll();
		return CustomerRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Customer findById(int theId) {
		Optional<Customer> result = CustomerRepository.findById(theId);

		Customer theCustomer = null;

		if (result.isPresent()) {
			theCustomer = result.get();
		} else {
			// we didn't find the Customer
			throw new RuntimeException("Did not find Customer id - " + theId);
		}

		return theCustomer;
	}

	@Override
	public Customer save(Customer theCustomer) {
		return CustomerRepository.save(theCustomer);
	}

	@Override
	public void deleteById(int theId) {
		CustomerRepository.deleteById(theId);
	}
}
