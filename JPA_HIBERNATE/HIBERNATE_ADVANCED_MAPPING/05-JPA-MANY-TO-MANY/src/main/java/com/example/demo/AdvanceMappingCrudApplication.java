package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.dao.AppDAO;
import com.example.demo.entity.Course;
import com.example.demo.entity.Student;

@SpringBootApplication
public class AdvanceMappingCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvanceMappingCrudApplication.class, args);
	}

	// THIS IS TO CREATE COMMAND LINE APPLICATION
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runner -> {
			// createCourseAndStudents(appDAO);
			// findCourseAndStudents(appDAO);
			//findStudentsAndCourse(appDAO);not working
			//addMoreCoursesForStudent(appDAO);not working
			//deletCourse(appDAO);not working
		};
	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {
		int theId = 2;
		Student s = appDAO.findStudentAndCourseByStudentId(theId);
		Course tempC=new Course("dd");

		s.addCourse(tempC);
		appDAO.save(tempC);
		System.out.print("DONE!");

	}

	/*private void findStudentsAndCourse(AppDAO appDAO) {
		int theId = 2;
		Student s = appDAO.findStudentAndCourseByCourseId(theId);
		System.out.print("DONE!");

	}
*/
	private void deletCourse(AppDAO appDAO) {
		int theId = 10;
		appDAO.deleteCourseById(theId);
		System.out.println("DONE");

	}
	private void findCourseAndStudents(AppDAO appDAO) {
		int theId = 10;
		Course tempC = appDAO.findCourseAndReviewsByCourseId(theId);
		System.out.print(tempC.getStudents());

		System.out.print("DONE!");

	}

	private void createCourseAndStudents(AppDAO appDAO) {

		// create a course
		Course TempC = new Course("temp");
		// create the student
		Student tempS1 = new Student("shi", "demo", "momo");
		Student tempS2 = new Student("aai", "mos", "omo");
		Student tempS3 = new Student("ghi", "emos", "moss");

		// add student to the couse
		TempC.addStudent(tempS1);
		TempC.addStudent(tempS2);
		TempC.addStudent(tempS3);

		// save the couse and association
		appDAO.save(TempC);
		System.out.print("DONE!");
	}

}
