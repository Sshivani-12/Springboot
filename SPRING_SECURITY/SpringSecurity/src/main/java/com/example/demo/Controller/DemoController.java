package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController
{
	@GetMapping("/")
	public String showHome()
	{
		return "home";
	}
//add a requestmapping for /leader

	@GetMapping("/leaders")
	public String showLeader()
	{
		return "leaders";
	}

	//add a requestmapping for /admin

		@GetMapping("/systems")
		public String showSystems()
		{
			return "systems";
		}
}
// we have restricted access based on roles here.