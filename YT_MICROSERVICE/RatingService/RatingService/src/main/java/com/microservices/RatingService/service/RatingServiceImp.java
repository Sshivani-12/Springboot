package com.microservices.RatingService.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.RatingService.entities.Rating;
import com.microservices.RatingService.repository.RatingRepository;

@Service
public class RatingServiceImp implements RatingService {

	@Autowired
	private RatingRepository ratingRepository;

	@Override
	public Rating saveUSer(Rating rating) {
		String random = UUID.randomUUID().toString();
		rating.setRatingId(random);
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getAllRating() {
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> geRatingByUserId(String userId) {
		return ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Rating> geRatingByHotelId(String hotelId) {
		return ratingRepository.findByHotelId(hotelId);
	}

}
