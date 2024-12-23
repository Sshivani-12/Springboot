package com.miccroservice.user.service.UserService.payload;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ApiResponse {

	private String message;
	private boolean success;
	private HttpStatus status;
	public void setMessage(String message2) {
		// TODO Auto-generated method stub
		
	}
	public void setStatus(HttpStatus notFound) {
		// TODO Auto-generated method stub
		
	}
	public void setSucess(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
