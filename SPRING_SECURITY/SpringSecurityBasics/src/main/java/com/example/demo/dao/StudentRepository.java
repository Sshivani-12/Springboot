package com.example.demo.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.student;

public interface StudentRepository extends JpaRepository<student, Integer> {


}

