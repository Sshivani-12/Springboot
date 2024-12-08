package com.example.demo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstrainValidator implements ConstraintValidator<CourseCode, String> {

	private String coursePrefix;

	@Override
	public void initialize(CourseCode theCourseCode) {
		coursePrefix = theCourseCode.value();

	}

	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatiorContext) {
		boolean result;
		if (theCode != null) {
			result = theCode.startsWith(coursePrefix);
		} else {
			return true;
		}
		return result;
	}

}

//This is your business logic and add this
// you can add database/ api trigger
