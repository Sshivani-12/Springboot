package com.jpa.test.dao;


import java.util.List;

import com.jpa.test.entity.Employee;

public interface EmployeeDAO {

	Employee findById(Integer id);

	void delete(Integer id);

	Employee save(Employee theStudent);

	List<Employee> findAll();

}