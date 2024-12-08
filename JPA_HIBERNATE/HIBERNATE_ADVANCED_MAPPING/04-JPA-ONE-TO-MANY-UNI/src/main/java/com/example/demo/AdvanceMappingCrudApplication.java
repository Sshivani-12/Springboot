package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.dao.AppDAO;
import com.example.demo.entity.Course;

@SpringBootApplication
public class AdvanceMappingCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvanceMappingCrudApplication.class, args);
	}

	// THIS IS TO CREATE COMMAND LINE APPLICATION
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runner -> {
			// createCourseAndReview(appDAO);
			// retriveCourseAndReviews(appDAO);
			deleteCourseAndReviews(appDAO);
		};
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int theId = 10;
		System.out.print("deleting course" + theId);
		appDAO.deleteCourseById(theId);
		System.out.print("DONE");

	}

	private void retriveCourseAndReviews(AppDAO appDAO) {
		// get the course and reviews
		int theId = 10;
		Course tempC = appDAO.findCourseAndReviewsByCourseId(theId);
		// print the course
		System.out.println(tempC);
		// print the reviews
		System.out.println(tempC.getReviews());
		System.out.print("DONE");

	}

	/*
	 * private void createCourseAndReview(AppDAO appDAO) {
	 * 
	 * // add course Course tempC = new Course("bat");
	 * 
	 * // add reviews tempC.addReview(new review("great!!")); tempC.addReview(new
	 * review("wowoow!!")); tempC.addReview(new review("Oh yaa!!"));
	 * 
	 * // save the reviews System.out.print(tempC.getReviews()); appDAO.save(tempC);
	 * System.out.print("DONE");
	 * 
	 * }
	 */

}
