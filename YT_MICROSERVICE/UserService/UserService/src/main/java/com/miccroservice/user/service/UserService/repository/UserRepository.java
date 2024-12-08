package com.miccroservice.user.service.UserService.repository;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

import com.miccroservice.user.service.UserService.entities.Users;

public interface UserRepository extends JpaRepository<Users,String>{

}