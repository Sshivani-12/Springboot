package com.luv2code.springboot.cruddemo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.cruddemo.entity.Customer;
import com.luv2code.springboot.cruddemo.service.CustomerService;

@Controller
@RequestMapping("/Customers")
public class CustomerController {

	private CustomerService eS;

	public CustomerController(CustomerService eSa) {
		eS = eSa;
	}

	@GetMapping("/list")
	public String listCustomers(Model m) {
		// get the Customer from db
		List<Customer> theCustomer = eS.findAll();
		m.addAttribute("Customers", theCustomer);
		return "Customers/list-Customers";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model m) {
		// get the Customer from db
		Customer theCustomer = new Customer();
		m.addAttribute("Customer", theCustomer);
		return "Customers/Customer-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("CustomerId") int theId, Model m) {
		// get the Customer from service
		Customer theCustomer = eS.findById(theId);
		// set Customer in the mdoel tp prepopulate the form
		m.addAttribute("Customer", theCustomer);
		// send it over to our form
		return "Customers/Customer-form";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("CustomerId") int theId) {
		// delete the Customer from service
		eS.deleteById(theId);
		// redirect to /Customer-form
		return "redirect:/Customers/list";
	}

	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute("Customer") Customer theCustomer) {
		// save the Customer from db

		eS.save(theCustomer);
		// redirect to prevent duplicate submissions
		return "redirect:/Customers/list";
	}
}
