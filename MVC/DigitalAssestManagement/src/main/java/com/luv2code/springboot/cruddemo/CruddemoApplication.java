package com.luv2code.springboot.cruddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

}


/*
 * http://localhost:8091/api/assets/upload
 * 
 *  Retrieve an Asset: Access a specific
 * asset by its ID with /api/assets/{id}. Search Assets: Search for assets with
 * a specific tag using /api/assets/search?tag={tag}.
 */