package com.example.we.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
@RequestMapping("/")	
public String home()//view return karte hai
{
	return "home";//view hai home
}
}
