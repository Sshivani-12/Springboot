package com.jpa.test.controller;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MyController {

	//http://localhost:9091/about
	
	@RequestMapping(value="/about", method=RequestMethod.GET)
	public String about(Model model)
	{
		System.out.println("inside about handler");

		//ADD DATA IN MODEL
		model.addAttribute("name","shivani");
		
		model.addAttribute("currentDate",new Date().toLocaleString());

		return "about";
		
	}
	
	//HANDLING ITERATION
	//http://localhost:9091/example-loop
	
	@GetMapping("/example-loop")
	public String iterateHandler(Model m) {
		//create a list,set or any collection
		//object->iterable;object->map,rray,single value as list
		//It can go through different data type as well
		
		List<String> names = List.of("shivani","p","m","c");
		m.addAttribute("names",names);
		
		return "iterate";
		
	} 
	
	//HANDLER FOR CONDITIONAL STATEMENT
	//http://localhost:9091/condition
		
	@GetMapping("/condition")
	public String conditionHandler(Model m)
	{
		m.addAttribute("isActive",true);
		m.addAttribute("gender","F");

		  List<Integer> list = List.of(223,23,42);
		  m.addAttribute("mylist",list);
		  return "condition";

	}
	
	//HANDLER FOR INCLUDING FRAGMENTS
	//http://localhost:9091/service

		@GetMapping("/service")
		public String servicesHandler(Model m)
		{
				  return "service";

		}
		//FOR NEW ABOUT
		@GetMapping("/aboutNew")
		public String newAbout()
		{
			return "aboutNew";
		}
	
}
