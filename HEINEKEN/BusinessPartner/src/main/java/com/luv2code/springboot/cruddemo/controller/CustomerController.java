package com.luv2code.springboot.cruddemo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.cruddemo.entity.Customer;
import com.luv2code.springboot.cruddemo.service.CustomerService;
import com.luv2code.springboot.cruddemo.vo.CustomerVo;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	private CustomerService customerService;

	public CustomerController(CustomerService eSa) {
		customerService = eSa;
	}

	@GetMapping("/list")
	public String listCustomer(Model model) {
		List<CustomerVo> customerList = customerService.findAll(); // Fetch data
		if (customerList == null || customerList.isEmpty()) {
			System.out.println("Customer list is null or empty"); // Debugging log
		}
		customerList.forEach(customer -> System.out.println(customer.getId() + " " + customer.getFirstName()));

		model.addAttribute("customers", customerList); // Add to model
		return "customers/list-customers"; // Template name
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		CustomerVo CustomerVo = new CustomerVo();
		model.addAttribute("customer", CustomerVo);
		return "customers/customer-form";
	}

	@PostMapping("/save")
	public String saveCustomer(@Valid @ModelAttribute("customer") CustomerVo CustomerVo, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			// If there are validation errors, return to the form page with error messages
			return "customers/customer-form";
		} else {
			Customer customer = new Customer();
			customer.setFirstName(CustomerVo.getFirstName());
			customer.setLastName(CustomerVo.getLastName());
			customer.setEmail(CustomerVo.getEmail());
			customerService.save(customer);
			return "redirect:/customers/list";
		}
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int customerId, Model model) {
		// Fetch the CustomerVo using the service
		CustomerVo customerVo = customerService.findById(customerId);

		// Add the VO to the model
		model.addAttribute("customer", customerVo);

		// Navigate to the form
		return "customers/customer-form";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int id) {
		customerService.deleteById(id);
		return "redirect:/customers/list";
	}
}
