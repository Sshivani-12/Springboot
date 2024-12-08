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

import com.jpa.test.dao.EmployeeDAO;
import com.jpa.test.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
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

	private EmployeeDAO employeeDAO;

	// quickly add and inject here//inject student dao
	public EmployeeRestController(EmployeeDAO themployeeDAO) {
		employeeDAO = themployeeDAO;
	}
//expose /student and return /student list	

	@GetMapping("/employee")
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

	@GetMapping("/employee/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee s = employeeDAO.findById(employeeId);
		if (s == null) {
			throw new RuntimeException("no employee!");
		}
		return s;
	}

	@PostMapping("/employee")
	public Employee addStudent(@RequestBody Employee employeeId) {
		employeeId.setId(0);
		Employee s = employeeDAO.save(employeeId);
		return s;
	}
	
	// UPDATE BOOKS HANDLER

		@PutMapping("/employee")
		public Employee updateStudent(@RequestBody Employee employeeId){
			Employee themployee = employeeDAO.save(employeeId);
			return themployee;
		}
		// DELETE BOOKS HANDLER

		@DeleteMapping("student/{studentId}")
		public String deleteStudent(@PathVariable("studentId") int employeeId) {
			Employee byId = employeeDAO.findById(employeeId);
			if(byId==null)
			{
				throw new RuntimeException("Employee is not found"+employeeId);
			}
			employeeDAO.delete(employeeId);
			return "deleted " + employeeId;
		}
}
