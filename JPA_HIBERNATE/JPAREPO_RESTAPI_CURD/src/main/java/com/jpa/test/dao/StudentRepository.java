package com.jpa.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.test.entity.student;

public interface StudentRepository extends JpaRepository<student, Integer> {

}
