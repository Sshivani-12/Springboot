package com.example.demo.entity;

import com.example.demo.validation.CourseCode;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Student {
	private String firstName;

	@NotNull(message = "is mandatory")
	@Size(min = 1, message = "is mandatory")
	private String lastName;

	@NotNull(message = "is mandatory")
	@Min(value = 0, message = "mustbe greater than or equal to zero")
	@Max(value = 10, message = "mustbe less than or equal to zero")
	private Integer freePasses;

	@Pattern(regexp = "^[a-zA-Z0-9]{5}",message = "only 5 chars/digits")
	private String postalCode;

	@CourseCode(value = "TOPS", message = "must start with TOPS")
	private String courseCode;
	
	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
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

}
