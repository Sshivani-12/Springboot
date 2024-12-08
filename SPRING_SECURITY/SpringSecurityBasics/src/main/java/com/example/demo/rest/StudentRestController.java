package com.example.demo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.student;
import com.example.demo.service.StudentService;


@RestController
@RequestMapping("/api")
public class StudentRestController {
	/*
	 * private StudentDAO studentdao;
	 * 
	 * //quickly add and inject here//inject student dao public
	 * StudentRestController(StudentDAO studentdao) { studentdao=studentdao; }
	 * //expose /student and return /student list
	 * 
	 * @GetMapping("/student") public List<student> findAll(){ return
	 * studentdao.findAll(); }
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
