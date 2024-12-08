package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
//basic mapping after port number

public class HomeController {

	private List<Student> theS;

	@PostConstruct
	public void loadData() {
		theS = new ArrayList<>();
		theS.add(new Student("shivani", "ss"));
		theS.add(new Student("as", "ss"));
		theS.add(new Student("sa", "ss"));

	}

	@GetMapping("/student")
	public List<Student> getStudents() {
		return theS;
	}

	// returns all students in list
	/*
	 * @GetMapping("/student")
	 * 
	 * @ResponseBody 
	 * public List<Student> home() 
	 * { 
	 * List<Student> theS=new ArrayList<>(); 
	 * theS.add(new Student("shivani","ss")); 
	 * theS.add(new Student("as","ss")); 
	 * theS.add(new Student("sa","ss"));
	 * return theS; 
	 * }
	 */

	// define endpoint or /student.{studentID} return student at index
	@GetMapping("/student/{studentId}")
	public Student getStudentId(@PathVariable int studentId) {

		// just index to list

		// check the studentId again list size

		if ((studentId >= theS.size()) | (studentId < 0)) {
			throw new StudentNotFoundException("student id noot found" + studentId);
		}

		return theS.get(studentId);
	}

	
}


/*
 * STEP 1: CREATE CUSTOM ERROR RESPONSE CLASS
 * STEP 2: CREATE A CUSTOM EXCEPTION CLASS
 * STEP 3: UPDATE REST SERVICE TO THROW EXCEPTION IF STUDENT NOT FOUND
 * STEP 4: ADD AN EXCEPTION HANDLER METHOD USING @EXCEPTIONHANDLER 
 * 
 * 
 * */
