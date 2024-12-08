package com.luv2code.springboot.cruddemo.exception;

import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

	// Handle CustomerNotFoundException
	@ExceptionHandler(CustomerNotFoundException.class)
	public ModelAndView handleCustomerNotFoundException(CustomerNotFoundException ex) {
		ModelAndView mav = new ModelAndView("error-page");
		mav.addObject("message", ex.getMessage());
		return mav;
	}

	// Handle generic exceptions
	@ExceptionHandler(Exception.class)
	public ModelAndView handleGenericException(Exception ex) {
		ModelAndView mav = new ModelAndView("error-page");
		mav.addObject("message", "An unexpected error occurred. Please try again later.");
		return mav;
	}

	@ExceptionHandler(BindException.class)
	public String handleValidationException(BindException ex, Model model) {
		model.addAttribute("errors", ex.getBindingResult().getAllErrors());
		return "error-page"; // Replace with your error page
	}
}
