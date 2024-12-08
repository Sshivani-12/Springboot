package com.jpa.test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.test.dao.StudentRepository;
import com.jpa.test.entity.student;


@Service
public class StudentSeviceImp implements StudentService {
	// define field for entity manager
	private StudentRepository studentrepo;

	// inject entity manager using constructor injection
	@Autowired
	public StudentSeviceImp(StudentRepository thstudentrepo) {
		studentrepo = thstudentrepo;
	}

	@Override
	public List<student> findAll() {
		return studentrepo.findAll();
	}

	@Override
	public student findById(int id) {
		// TODO Auto-generated method stub
		student thestudent = null;
		Optional<student> result = studentrepo.findById(id);
		if (result.isPresent()) {
			thestudent = result.get();
		} else {
			throw new RuntimeException("did not find" + id);
		}
		return thestudent;
	}

	@Override
	public void delete(int id) {
		studentrepo.deleteById(id);
	}

	@Override
	public student save(student theStudent) {
		// TODO Auto-generated method stub
		return studentrepo.save(theStudent);
	}

}
