package com.microservices.RatingService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.RatingService.entities.Rating;
import com.microservices.RatingService.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	RatingService ratingservice;

	@PostMapping
	public ResponseEntity<Rating> createUser(@RequestBody Rating rating) {
		Rating rating1 = ratingservice.saveUSer(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(rating1);
	}

	@GetMapping
	public ResponseEntity<List<Rating>> getAllRating() {
		List<Rating> allRating = ratingservice.getAllRating();
		return ResponseEntity.ok(allRating);
	}

	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> geRatingByUserId(@PathVariable String userId) {
		List<Rating> user1 = ratingservice.geRatingByUserId(userId);
		return ResponseEntity.ok(user1);
	}

	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> geRatingByHotelId(@PathVariable String hotelId) {
		List<Rating> hotel1 = ratingservice.geRatingByHotelId(hotelId);
		return ResponseEntity.ok(hotel1);
	}

}
