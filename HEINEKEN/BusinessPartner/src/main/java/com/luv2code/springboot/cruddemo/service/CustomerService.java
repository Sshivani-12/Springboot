package com.luv2code.springboot.cruddemo.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.cruddemo.entity.Customer;
import com.luv2code.springboot.cruddemo.exception.CustomerNotFoundException;
import com.luv2code.springboot.cruddemo.repository.CustomerRepository;
import com.luv2code.springboot.cruddemo.vo.CustomerVo;

@Service
public class CustomerService {

	private final CustomerRepository customerRepository;

	@Autowired
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	// Get all customers and return a list of CustomerVO
	public List<CustomerVo> findAll() {
	    return customerRepository.findAll()
	            .stream()
	            .map(this::convertToVo) // Convert each entity to VO
	            .collect(Collectors.toList());
	}

	// Get customer by id and return a CustomerVO
    public CustomerVo findById(Integer id) {
        return customerRepository.findById(id)
                .map(this::convertToVo)
                .orElseThrow(() -> new RuntimeException("Customer not found for id: " + id));
    }

    private CustomerVo convertToVo(Customer customer) {
        CustomerVo customerVo = new CustomerVo();
        customerVo.setId(customer.getId());
        customerVo.setFirstName(customer.getFirstName());
        customerVo.setLastName(customer.getLastName());
        customerVo.setEmail(customer.getEmail());
        return customerVo;
    }
	// Save or update customer
	public void save(Customer customer) {
		customerRepository.save(customer);
	}

	// Delete customer by id
	public void deleteById(int id) {
		if (!customerRepository.existsById(id)) {
			throw new CustomerNotFoundException("Customer with ID " + id + " not found.");
		}
		customerRepository.deleteById(id);
	}
}
