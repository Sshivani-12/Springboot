package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Instructor;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class AppDAOImp implements AppDAO {

	// DEFINE FIELD FOR ENTITY MANAGER
	private EntityManager entityManager;
	// INJECT ENTITY MANAGER USING CONSTRUCTOR INJECTION

	@Autowired
	public AppDAOImp(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void save(Instructor theInstructor) {
		entityManager.persist(theInstructor);
	}

	@Override
	public Instructor findInstructorById(int theId) {

		return entityManager.find(Instructor.class, theId);
	}

	@Override
	@Transactional
	public void deleteInstructorById(int theId) {
		//RETRIVE THE INSTRUCTORS
		Instructor i=entityManager.find(Instructor.class,theId);
		//delete the instructor
		entityManager.refresh(i);
		
	}

}
