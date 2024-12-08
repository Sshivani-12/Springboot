package com.jpa.test.controller;


import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jpa.test.entities.LoginData;

import ch.qos.logback.core.model.Model;
import jakarta.validation.Valid;

@Controller
public class MyController {

	@GetMapping("/form")
	public String openForm(Model m) {
		return "form";
	}

	// HANDLER FOR PROCESS FORM
	@PostMapping("/process")

	// only when valid is added befor model it will get triggered
	public String processForm(@Valid @ModelAttribute("loginData") LoginData loginData,BindingResult result) {
		
		if(result.hasErrors())
		{
			System.out.print("error hai!");
			return "form";

		}
		return "success";
	}
}
 