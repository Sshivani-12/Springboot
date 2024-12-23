package com.miccroservice.user.service.UserService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.miccroservice.user.service.UserService.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler()
	public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFound resourceNotFound) {

		//ApiResponse response = ApiResponse.builder().message(message).sucess(true).status(HttpStatus.NOT_FOUND);
	    String message = resourceNotFound.getMessage();
	    ApiResponse response = new ApiResponse();
	    response.setMessage(message);
	    response.setSucess(true);
	    response.setStatus(HttpStatus.NOT_FOUND);

	    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

	}
}
