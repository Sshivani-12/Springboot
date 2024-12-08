package com.jpa.test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jpa.test.entity.student;

public interface StudentService {
	student findById(int id);

	void delete(int id);

	student save(student theStudent);

	List<student> findAll();
	  
}
