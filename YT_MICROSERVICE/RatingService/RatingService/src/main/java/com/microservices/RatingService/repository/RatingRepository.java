package com.microservices.RatingService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.RatingService.entities.Rating;

public interface RatingRepository extends JpaRepository<Rating,String>{

	//create custom menthods here
	//after findby it should be same as your name in entity in camel case
	List<Rating> findByUserId(String userId);
	
	List<Rating> findByHotelId(String hotelId);
	
}
