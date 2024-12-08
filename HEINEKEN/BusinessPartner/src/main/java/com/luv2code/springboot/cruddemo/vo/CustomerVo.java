package com.luv2code.springboot.cruddemo.vo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CustomerVo {


    
	private int id;

    @NotBlank(message = "First name is mandatory")
    @Size(min = 2, message = "First name must have at least 2 characters")
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    private String lastName;

    @Email(message = "Please provide a valid email address")
    private String email;
    
    public CustomerVo(int id2, String firstName2, String lastName2, String email2) {
		// TODO Auto-generated constructor stub
	}
	public CustomerVo() {
		// TODO Auto-generated constructor stub
	}
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
    
}
