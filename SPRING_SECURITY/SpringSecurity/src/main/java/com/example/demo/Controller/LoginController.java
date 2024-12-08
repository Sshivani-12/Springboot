package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController
{
/*
  @GetMapping("/showMyLoginPage")
 
public String showMyLoginPage()
{
	return "plain-login";
}
*/

@GetMapping("/showMyLoginPage")
public String showMyLoginPage()
{
	return "fancy-login";
}

//add request mapping for /access-denied 
@GetMapping("/acess-denied")
public String showAccessDenied()
{
	return "acess-denied";
}
}
