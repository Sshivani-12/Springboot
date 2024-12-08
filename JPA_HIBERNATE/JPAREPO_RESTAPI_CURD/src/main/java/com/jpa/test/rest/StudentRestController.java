package com.jpa.test.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.test.entity.student;
import com.jpa.test.service.StudentService;

//@RestController indicates that this controller is supported by rest service i.e via postman
@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	
	/*
	 * @GetMapping("/students")
	 * public List <student> getStudents(){
	 * List<student>s=new ArrayList<>();//populate with student object
	 * s.add(new student("Poornima","parw"));//here pojo is converted to json via jocksen
	 * return s;
	 * }
	 * 
	 * or use PostConstructor(we only load student data at once)
	 * 
	 * private List<student>s
	 * 
	 * @PostConstructor
	 * public void loadData(){
	 * s=new ArrayList<>();
	 * s.add(new student("Poornima","parw"));//here pojo is converted to json via jocksen
	 * }
	 * 
	 * @GetMapping("/students")
	 * public List <student> getStudents(){
	 * return s;
	 * }

	 */

	private StudentService studentservice;

	// quickly add and inject here//inject student dao
	public StudentRestController(StudentService thstudentservice) {
		studentservice = thstudentservice;
	}

	//expose /student and return /student list	
	@GetMapping("/student")
	public List<student> findAll() {
		return studentservice.findAll();
	}

	//{studentId} is called as path variable, in postman we will pass value here
	//value of {studentId} and findById(studentId) should be same
	
	@GetMapping("/student/{studentId}")
	public student getStudent(@PathVariable int studentId) {
		student s = studentservice.findById(studentId);
		if (s == null) {
			throw new RuntimeException("no employee!");
		}
		return s;
	}

	@PostMapping("/student")
	public student addStudent(@RequestBody student studentId) {
		studentId.setId(0);
		student s = studentservice.save(studentId);
		return s;
	}
	
	// UPDATE BOOKS HANDLER

		@PutMapping("/student")
		public student updateStudent(@RequestBody student student){
			student thstudent = studentservice.save(student);
			return thstudent;
		}
		// DELETE BOOKS HANDLER

		@DeleteMapping("student/{studentId}")
		public String deleteStudent(@PathVariable("studentId") int studentId) {
			student byId = studentservice.findById(studentId);
			if(byId==null)
			{
				throw new RuntimeException("Employee is not found"+studentId);
			}
			studentservice.delete(studentId);
			return "deleted " + studentId;
		}
}
