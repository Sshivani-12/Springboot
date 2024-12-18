package com.miccroservice.user.service.UserService.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "micro_users")
public class Users {

	@Id
	@Column(name = "ID")
	private String userId;
	@Column(name = "Name", length = 10)
	private String name;
	@Column(name = "EmailId", length = 10)
	private String email;
	@Column(name = "About", length = 10)
	private String about;

	// data base mai store nhi karega
	@Transient
	private List<Rating> ratings=new ArrayList<>();

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

}
