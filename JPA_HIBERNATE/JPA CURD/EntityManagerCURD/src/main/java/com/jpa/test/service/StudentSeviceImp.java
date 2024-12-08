package com.jpa.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.test.dao.StudentDAO;
import com.jpa.test.entity.student;

import jakarta.transaction.Transactional;

@Service
public class StudentSeviceImp implements StudentService {
	// define field for entity manager
	private StudentDAO studentdao;

	// inject entity manager using constructor injection
	@Autowired
	public StudentSeviceImp(StudentDAO thstudentdao) {
		studentdao = thstudentdao;
	}

	@Override
	public List<student> findAll() {
		return studentdao.findAll();
	}

	@Override
	public student findById(Integer id) {
		// TODO Auto-generated method stub
		return studentdao.findById(id);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		studentdao.delete(id);
	}

	@Override
	@Transactional
	public student save(student theStudent) {
		// TODO Auto-generated method stub
		return studentdao.save(theStudent);
	}

}
