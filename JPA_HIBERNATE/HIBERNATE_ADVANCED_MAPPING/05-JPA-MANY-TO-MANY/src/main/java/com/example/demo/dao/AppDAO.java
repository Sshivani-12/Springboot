package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetail;
import com.example.demo.entity.Student;

public interface AppDAO {

	void save(Instructor theInstructor);

	Instructor findInstructorById(int theId);

	void deleteInstructorById(int theId);

	InstructorDetail findInstructorDetailById(int theId);
	
	InstructorDetail deleteInstructorDetailById(int theId);

	List<Course> findCoursesByInstructoreId(int theId);
	
	Instructor findInstructorByIdJoinFetch(int theId);
	
	
	void update(Instructor theInstructor);
	void update(Course tempCourse);
	Course findCourseById(int theId);
	
	void deleteCourseById(int theId);

	void save(Course theCourse);
	Course findCourseAndReviewsByCourseId(int theId);
	Course findCourseAndStudentByCourseId(int theId);
	Student findStudentAndCourseByCourseId(int theId);

	void update(Student theStudent);

	Student findStudentAndCourseByStudentId(int theId);

	

}
