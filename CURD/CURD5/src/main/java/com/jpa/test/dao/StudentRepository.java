package com.jpa.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jpa.test.entity.student;

// http://localhost:8090/magic-api/members
@RepositoryRestResource(path="members")
public interface StudentRepository extends JpaRepository<student, Integer> {

}
