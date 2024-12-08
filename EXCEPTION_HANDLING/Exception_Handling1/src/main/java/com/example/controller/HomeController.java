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


/*
 * STEP 1: CREATE CUSTOM ERROR RESPONSE CLASS
 * STEP 2: CREATE A CUSTOM EXCEPTION CLASS
 * STEP 3: UPDATE REST SERVICE TO THROW EXCEPTION IF STUDENT NOT FOUND
 * STEP 4: ADD AN EXCEPTION HANDLER METHOD USING @EXCEPTIONHANDLER 
 * 
 * 
 * */
