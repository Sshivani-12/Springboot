package com.miccroservice.user.service.UserService.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "micro_rating")
public class Rating {

	@Id
	@Column(name = "ID")
	private String userId;

	private String ratingId;
	private String hotelId;
	private int rating;
	private String feedback;

	// private Hotel hotel;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRatingId() {
		return ratingId;
	}

	public void setRatingId(String ratingId) {
		this.ratingId = ratingId;
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Rating(String userId, String ratingId, String hotelId, int rating, String feedback) {
		super();
		this.userId = userId;
		this.ratingId = ratingId;
		this.hotelId = hotelId;
		this.rating = rating;
		this.feedback = feedback;
	}

	public Rating() {
		super();
	}
}
