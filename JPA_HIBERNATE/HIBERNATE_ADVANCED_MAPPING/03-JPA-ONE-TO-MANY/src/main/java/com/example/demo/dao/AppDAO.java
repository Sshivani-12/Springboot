package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetail;

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

}