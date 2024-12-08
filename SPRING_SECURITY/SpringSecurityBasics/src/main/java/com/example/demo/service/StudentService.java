package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.student;


public interface StudentService {
	student findById(int id);

	void delete(int id);

	student save(student theStudent);

	List<student> findAll();
	  
}
