package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetail;
import com.example.demo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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

	/*
	 * @Override
	 * 
	 * @Transactional public void deleteInstructorById(int theId) { // RETRIVE THE
	 * INSTRUCTORS Instructor i = entityManager.find(Instructor.class, theId); //
	 * delete the instructor entityManager.remove(i);
	 * 
	 * }
	 */

	//
	@Override
	@Transactional
	public void deleteInstructorById(int theId) {
		// RETRIVE THE INSTRUCTORS
		Instructor i = entityManager.find(Instructor.class, theId);

		// get the course
		List<Course> courses = i.getCourses();
		// break association of all courses for the instructor
		for (Course tC : courses) {
			tC.setInstructor(null);
		}
		// delete the instructor
		entityManager.remove(i);

	}

	@Override
	public InstructorDetail findInstructorDetailById(int theId) {

		return entityManager.find(InstructorDetail.class, theId);
	}

	@Override
	@Transactional
	public InstructorDetail deleteInstructorDetailById(int theId) {

		InstructorDetail tempD = entityManager.find(InstructorDetail.class, theId);
		// remove the associatiom object reference

		tempD.getInstructor().setInstructorDetail(null);
		// delete the record
		entityManager.remove(tempD);
		return null;
	}

	@Override
	public List<Course> findCoursesByInstructoreId(int theId) {
		TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id=:data", Course.class);

		query.setParameter("data", theId);
		// execute the query
		List<Course> courses = query.getResultList();
		return courses;
	}

	@Override
	public Instructor findInstructorByIdJoinFetch(int theId) {

		TypedQuery<Instructor> query = entityManager
				.createQuery("select i from Instructor i join FETCH i.courses where i.id=:data", Instructor.class);

		query.setParameter("data", theId);
		// execute the query
		Instructor i = query.getSingleResult();
		return i;
	}

	@Override
	@Transactional
	public void update(Instructor theInstructor) {
		entityManager.merge(theInstructor);
	}

	// update in database
	@Override
	@Transactional
	public void update(Course tempCourse) {
		entityManager.merge(tempCourse);

	}

	@Override
	public Course findCourseById(int theId) {

		return entityManager.find(Course.class, theId);
	}

	@Override
	@Transactional
	public void deleteCourseById(int theId) {
		// retrive the course
		Course c = entityManager.find(Course.class, theId);

		// delete the course
		entityManager.remove(c);

	}

	@Override
	@Transactional
	public void save(Course theCourse) {
		entityManager.persist(theCourse);
	}

	@Override
	public Course findCourseAndReviewsByCourseId(int theId) {

		// create query
		TypedQuery<Course> q = entityManager.createQuery("select c from Course c join fetch c.reviews where c.id=:data",
				Course.class);

		// execute query
		q.setParameter("data", theId);
		Course c = q.getSingleResult();

		return c;
	}

	@Override
	public Course findCourseAndStudentByCourseId(int theId) {

		// create query
				TypedQuery<Course> q = entityManager.createQuery("select c from Course c join fetch c.students where c.id=:data",
						Course.class);

				// execute query
				q.setParameter("data", theId);
				Course c = q.getSingleResult();

				return c;	
				}

	@Override
	public Student findStudentAndCourseByCourseId(int theId) {

		// create query
		TypedQuery<Student> q = entityManager.createQuery("select c from Course c join fetch c.courses where c.id=:data",
				Student.class);

		// execute query
		q.setParameter("data", theId);
		Student c = q.getSingleResult();

		return c;
		}

	@Override
	public void update(Student theStudent) {
		entityManager.merge(theStudent);

		
	}

	@Override
	public Student findStudentAndCourseByStudentId(int theId) {

		// create query
		TypedQuery<Student> q = entityManager.createQuery("select c from Course c join fetch c.courses where c.id=:data",
				Student.class);

		// execute query
		q.setParameter("data", theId);
		Student c = q.getSingleResult();

		return c;	
	}

}
