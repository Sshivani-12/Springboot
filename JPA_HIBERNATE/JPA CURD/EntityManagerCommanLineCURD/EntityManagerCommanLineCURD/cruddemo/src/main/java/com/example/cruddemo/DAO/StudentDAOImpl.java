package com.example.cruddemo.DAO;

import com.example.cruddemo.entity.student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

	// implement save method
	@Override
	@Transactional
	public void save(student theStudent) {
		entityManager.persist(theStudent);
	}

	@Override
	public student findById(Integer id) {
		return entityManager.find(student.class, id);
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
	public List<student> findByLastName(String theLastName) {
		// create query
		//here student is entity name/class name and entity type not table name
		TypedQuery<student> theQuery = entityManager.createQuery("FROM student WHERE lastName=:theData", student.class);

		// set query parameters
		theQuery.setParameter("theData", theLastName);

		// return query results
		return theQuery.getResultList();
	}

	@Override
	@Transactional
	public void update(student theStudent) {
		entityManager.merge(theStudent);

	}

	@Override
	@Transactional
	public void delete(Integer id) {
		student theStudent = entityManager.find(student.class, id);

		// delete the student
		entityManager.remove(theStudent);
	}

	@Override
	public int deleteAll() {
		int numRowsDeleted = entityManager.createQuery("DELETE FROM student").executeUpdate();

		return numRowsDeleted;
	}

}