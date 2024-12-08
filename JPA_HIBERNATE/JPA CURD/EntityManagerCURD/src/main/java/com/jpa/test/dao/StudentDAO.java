package com.jpa.test.dao;


import java.util.List;

import com.jpa.test.entity.student;

public interface StudentDAO {

	student findById(Integer id);

	void delete(Integer id);

	student save(student theStudent);

	List<student> findAll();

}