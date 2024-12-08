package com.example.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.dao.AppDAO;
import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetail;

@SpringBootApplication
public class AdvanceMappingCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvanceMappingCrudApplication.class, args);
	}

	// THIS IS TO CREATE COMMAND LINE APPLICATION
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		/*
		 * return runner -> { System.out.print("Hello WOrld"); };
		 */
		return runner -> {
			// createInstructor(appDAO);working
			// findIstrictor(appDAO);working
			// deleteInstructorById(appDAO);working
			// findInstructorDetail(appDAO);working
			// deleteInstructorDetail(appDAO);working
			// createInstructorWithCourses(appDAO);working
			// findInstructorWithCourse(appDAO);not working
			// findCoursesForInstructor(appDAO);not working
			// findInstructorWithCourseByIdJoinFetch(appDAO);not working
			// updateInstructor(appDAO);working
			// updateCourse(appDAO);working
			// deleteInstructor(appDAO);working
			deletCourse(appDAO);
		};
	}

	private void deletCourse(AppDAO appDAO) {
		int theId = 10;
		appDAO.deleteCourseById(theId);
		System.out.println("DONE");

	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 1;
		appDAO.deleteInstructorById(theId);
		System.out.println("DONE");

	}

	private void updateCourse(AppDAO appDAO) {
		int theId = 10;

		// find course
		Course c = appDAO.findCourseById(theId);

		// update the course
		System.out.print("updating course id" + theId);
		c.setTitle("new updated");
		appDAO.update(c);
		System.out.println("DONE");

	}

	private void updateInstructor(AppDAO appDAO) {

		int theId = 1;
		// find instructor
		Instructor i = appDAO.findInstructorById(theId);
		// update data
		System.out.println("Updating instructor id" + theId);
		i.setLastName("tester");

		appDAO.update(i);
		System.out.println("DONE");

	}

	private void findInstructorWithCourseByIdJoinFetch(AppDAO appDAO) {
		int theId = 1;
		Instructor t = appDAO.findInstructorByIdJoinFetch(theId);
		System.out.println("Temp Instructor" + t);
		System.out.println("Temp Instructor" + t.getCourses());
		System.out.println("DONE");

	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("id" + theId);
		Instructor i = appDAO.findInstructorById(theId);// not working
		System.out.println("Temp Instructor" + i);
		System.out.println("Temp Instructor course" + i.getCourses());
		// associate the objects
		List<Course> c = appDAO.findCoursesByInstructoreId(theId);
		i.setCourses(c);

		System.out.println("DONE");

	}

	private void findInstructorWithCourse(AppDAO appDAO) {
		int theId = 1;
		System.out.println("id" + theId);
		Instructor i = appDAO.findInstructorById(theId);
		System.out.println("Temp Instructor" + i);
		System.out.println("Temp Instructor course" + i.getCourses());
		System.out.println("DONE");

	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor i = new Instructor("madhu", "sa", "as");
		InstructorDetail id = new InstructorDetail("sa", "as");
		i.setInstructorDetail(id);

		// create course
		Course tc1 = new Course("book4");
		Course tc2 = new Course("book5");
		Course tc3 = new Course("book6");

		i.add(tc1);
		i.add(tc2);
		i.add(tc3);

		// saving instructor
		System.out.print("saving" + i);
		System.out.print("saveds" + i.getCourses());
		appDAO.save(i);
		System.out.print("DONE");

	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 2;

//PRINT THE INSTRUCTOR DETAIL
		System.out.print("Instructirdetails" + theId);

		appDAO.deleteInstructorById(theId);
// PRINT THE ASSOCIATED INSTRUCTOR
		System.out.print("DONE");
	}

	private void findInstructorDetail(AppDAO appDAO) {

		// GET THE INSTRUCTOR DETAIL OBJECT
		int theId = 2;
		InstructorDetail i = appDAO.findInstructorDetailById(theId);
		// PRINT THE INSTRUCTOR DETAIL
		System.out.print("Instructirdetails" + i);
		// PRINT THE ASSOCIATED INSTRUCTOR
		System.out.print("Instructirdetails" + i.getInstructor());
		System.out.print("DONE");

	}

	private void deleteInstructorById(AppDAO appDAO) {
		int theID = 1;
		System.out.println("Deleteing the instructor id:" + theID);
		appDAO.deleteInstructorById(theID);
		System.out.print("DONE!");

	}

	private void findIstrictor(AppDAO appDAO) {
		int theId = 1;
		System.out.print("finding instructor id" + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.print("theinstructor id" + tempInstructor);
		System.out.print("instructordetails" + tempInstructor.getInstructorDetail());

	}

	private void createInstructor(AppDAO appDAO) {

		// CREATE THE INSTRUCTOR Instructor tempInstructor = new
		//Instructor("Chad", "darby", "char@da@gmail.com");

		// create the instructor details

		//InstructorDetail instructordetail = new InstructorDetail("http", "code!");
		//tempInstructor.setInstructorDetail(instructordetail); // save instructor //
		// This will also save the details object // beacuse of cascade all
		//System.out.print(tempInstructor);
		//appDAO.save(tempInstructor);

	}

}
