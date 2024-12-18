package com.microservice.HotelService.HotelService.controller;

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

import com.microservice.HotelService.HotelService.entities.Hotel;
import com.microservice.HotelService.HotelService.service.HotelService;

@RequestMapping("/hotels")
@RestController
public class HotelController {
	@Autowired
	HotelService hotelservice;

	@PostMapping
	public ResponseEntity<Hotel> createUser(@RequestBody Hotel user) {
		Hotel user1 = hotelservice.saveHotel(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<Hotel> getSingleUser(@PathVariable String userId) {
		Hotel user1 = hotelservice.getHotel(userId);
		return ResponseEntity.ok(user1);
	}

	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotel() {
		List<Hotel> allHotel = hotelservice.getAllHotel();
		return ResponseEntity.ok(allHotel);
	}
}
