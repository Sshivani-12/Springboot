package com.miccroservice.user.service.UserService.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//import com.miccroservice.user.service.UserService.entities.Hotel;
import com.miccroservice.user.service.UserService.entities.Rating;
import com.miccroservice.user.service.UserService.entities.Users;
import com.miccroservice.user.service.UserService.exception.ResourceNotFound;
import com.miccroservice.user.service.UserService.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepository;

	final Logger logger = LoggerFactory.getLogger(UserServiceImp.class);

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Users saveUSer(Users user) {
		String random = UUID.randomUUID().toString();
		user.setUserId(random);
		return userRepository.save(user);
	}

	@Override
	public List<Users> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public Users getUser(String userId) {
		Users user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFound("user with given ID not found" + userId));
		// fetching rating of above user from Rating SERVICE
		// http://localhost:8083/ratings/users/f5c4c45a-5f0a-4d2f-8c07-8ce7b62fa9e2
		//ArrayList<Rating> ratingarrays = restTemplate.getForObject("http://localhost:8083/ratings/users/" + user.getUserId(), ArrayList.class);
		
		
		// use service ka nam instead of localhost and port
		ArrayList<Rating> ratingarrays = restTemplate.getForObject("http://USERSERVICE/ratings/users/" + user.getUserId(), ArrayList.class);

		logger.info("{}", ratingarrays);

		/*
		 * Rating[] ratingarrays =
		 * restTemplate.getForObject("http://localhost:8083/ratings/users/" +
		 * user.getUserId(), Rating[].class);
		 * 
		 * List<Rating> ratings = Arrays.stream(ratingarrays).toList(); List<Rating>
		 * ratingList = ratings.stream().map(rating -> { //
		 * http://localhost:8082/hotels/-4e81-4325-a8f7-c8d1d07f9abf
		 * 
		 * ResponseEntity<Hotel> hotel1 = restTemplate
		 * .getForEntity("http://localhost:8082/hotels/" + rating.getHotelId(),
		 * Hotel.class); Hotel hotel = hotel1.getBody();
		 * 
		 * logger.info("response sttaus code {}", hotel1.getStatusCode());
		 * 
		 * return rating; }).collect(Collectors.toList());
		 */
		user.setRatings(ratingarrays);
		return user;
		// in postman : http://localhost:8081/users/f5c4c45a-5f0a-4d2f-8c07-8ce7b62fa9e2
	}

	@Override
	public Users deleteUser(String userId) {
		return null;
	}

	@Override
	public Users updateUser(String userId) {
		return null;
	}

}
