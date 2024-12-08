package com.example.demo.controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Student;

import jakarta.validation.Valid;

@Controller
public class CustomerController {

	@GetMapping("/")
	public String showform(Model m) {
		m.addAttribute("customer", new Student());
		return "customer-form";

	}

	@PostMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Student thecus, BindingResult br) {
	
		System.out.print("last name|"+thecus.getLastName());

		System.out.print("Binding results"+ br.toString());
		System.out.print("\n\n\n\n\n");
		if (br.hasErrors()) {
			return "customer-form";
		}
		return "customer-confirmation";

	}
	
	//add init binder to convert input string
	//remove validation issue
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder)
	{
		StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
}
