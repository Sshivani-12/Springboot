package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.dao.AppDAO;
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
			//createInstructor(appDAO);
			 //findIstrictor(appDAO);
			 //deleteInstructorById(appDAO);
			// findInstructorDetail(appDAO);\
			deleteInstructorDetail(appDAO);
		};
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

	/*
	 * private void deleteInstructorById(AppDAO appDAO) { int theID = 1;
	 * System.out.println("Deleteing the instructor id:" + theID);
	 * appDAO.deleteInstructorById(theID); System.out.print("DONE!");
	 * 
	 * }
	 * 
	 * private void findIstrictor(AppDAO appDAO) { int theId = 1;
	 * System.out.print("finding instructor id" + theId); Instructor tempInstructor
	 * = appDAO.findInstructorById(theId); System.out.print("theinstructor id" +
	 * tempInstructor); System.out.print("instructordetails" +
	 * tempInstructor.getInstructorDetail());
	 * 
	 * }
	 * 
	 */
	/*private void createInstructor(AppDAO appDAO) {
		 
	  // CREATE THE INSTRUCTOR 
	Instructor tempInstructor = new Instructor("Chad","darby", "char@da@gmail.com");
	  
	  // create the instructor details
	  
	  InstructorDetail instructordetail = new InstructorDetail("http", "code!");
	  tempInstructor.setInstructorDetail(instructordetail); // save instructor //
	  //This will also save the details object // beacuse of cascade all
	  System.out.print(tempInstructor); 
	  appDAO.save(tempInstructor);
	
	  }
	   */
}
