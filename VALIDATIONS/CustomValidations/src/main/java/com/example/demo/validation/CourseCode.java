package com.example.demo.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = CourseCodeConstrainValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)

public @interface CourseCode {

	//define default class code
	public String value() default "ZZZ";

	//define default error message
	public String message() default "must start with ZZZ";

	//define default groups
	public Class<?>[] groups() default {};
	
	//define default payloads 
	public Class<? extends Payload>[] payload() default {};
}
