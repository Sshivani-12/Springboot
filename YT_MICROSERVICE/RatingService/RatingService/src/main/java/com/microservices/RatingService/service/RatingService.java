package com.microservices.RatingService.service;

import java.util.List;

import com.microservices.RatingService.entities.Rating;

public interface RatingService {

	Rating saveUSer(Rating rating);

	List<Rating> getAllRating();

	List<Rating> geRatingByUserId(String userId);

	List<Rating> geRatingByHotelId(String hotelId);
}
