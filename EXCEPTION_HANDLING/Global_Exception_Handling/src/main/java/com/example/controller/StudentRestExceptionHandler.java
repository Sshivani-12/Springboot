package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// all exceptions in one file for larger projects
@ControllerAdvice
public class StudentRestExceptionHandler {

	//add exception handling code here
	
	// Add an exception handler using @ExceptionHandler
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exec) {

			// create student error response
			// url: http://localhost:8090/api/student/9899898

			StudentErrorResponse error = new StudentErrorResponse();
			error.setStatus(HttpStatus.NOT_FOUND.value());
			error.setMessage(exec.getMessage());
			error.setTimeStamp(System.currentTimeMillis());

			// return responseentity
			return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

		}
	 
		// add another exception handler .. to catch all exception
		// url: http://localhost:8090/api/student/srdfdf

		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException(Exception exec) {
			// create student error response
			StudentErrorResponse error = new StudentErrorResponse();
			error.setStatus(HttpStatus.BAD_REQUEST.value());
			error.setMessage(exec.getMessage());
			error.setTimeStamp(System.currentTimeMillis());

			// return responseentity
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

		}
}
