package com.jpa.test.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jpa.test.entity.student;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

	// define field for entity manager
	private EntityManager entityManager;

	// inject entity manager using constructor injection
	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<student> findAll() {
		// create query
		TypedQuery<student> theQuery = entityManager.createQuery("FROM student", student.class);
		// student is entity name and entity filed not database name
		// return query results
		List<student> resultList = theQuery.getResultList();
		return resultList;
	}

	@Override
	public student findById(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(student.class, id);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		student theStudent = entityManager.find(student.class, id);

		// delete the student
		entityManager.remove(theStudent);

	}

	@Override
	@Transactional
	public student save(student theStudent) {
		student s = entityManager.merge(theStudent);
		return s;
	}

}