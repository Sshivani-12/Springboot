package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Student;

@Controller
public class StudentController {
	// flow--> student-form->controller->confiration page
	
	//take all list of values from application.properties 
	@Value("${countries}")
	private List<String> countries;
	
	@Value("${languages}")
	private List<String> languages;
	
	
	@Value("${systems}")
	private List<String> systems;
	
	@GetMapping("/showStudentForm")
	public String showForm(Model theModel) {

		// create student object
		Student s = new Student();

		// add student object to model
		theModel.addAttribute("student", s);
		
		//add the list of countries to model
		theModel.addAttribute("countries",countries);
		
		//add the list of languages to model
		theModel.addAttribute("languages",languages);
				
		//add the list of favoriteSystem to model
		theModel.addAttribute("systems",systems);
	
		return "student-form";

	}

	@PostMapping("/processStudentForm")
	public String processForm(@ModelAttribute("student") Student thStudent) {

		return "student-confirmation";

	}
}
