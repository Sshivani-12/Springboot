package com.miccroservice.user.service.UserService.controller;

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

import com.miccroservice.user.service.UserService.entities.Users;
import com.miccroservice.user.service.UserService.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userservice;

	@PostMapping
	public ResponseEntity<Users> createUser(@RequestBody Users user) {
		Users user1 = userservice.saveUSer(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<Users> getSingleUser(@PathVariable String userId) {
		Users user1 = userservice.getUser(userId);
		return ResponseEntity.ok(user1);
	}

	@GetMapping
	public ResponseEntity<List<Users>> getAllUsers() {
		List<Users> allUsers = userservice.getAllUser();
		return ResponseEntity.ok(allUsers);
	}
}
