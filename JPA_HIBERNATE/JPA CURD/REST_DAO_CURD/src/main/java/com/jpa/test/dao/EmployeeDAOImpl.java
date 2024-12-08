package com.jpa.test.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jpa.test.entity.Employee;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	// define field for entity manager
	private EntityManager entityManager;

	// inject entity manager using constructor injection
	@Autowired
	public EmployeeDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		// create query
		TypedQuery<Employee> theQuery = entityManager.createQuery("FROM student", Employee.class);
		// student is entity name and entity filed not database name
		// return query results
		List<Employee> resultList = theQuery.getResultList();
		return resultList;
	}

	@Override
	public Employee findById(Integer id) {
		return entityManager.find(Employee.class, id);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Employee theStudent = entityManager.find(Employee.class, id);

		// delete the student
		entityManager.remove(theStudent);

	}

	@Override
	@Transactional
	public Employee save(Employee theStudent) {
		Employee s = entityManager.merge(theStudent);
		return s;
	}

}