package com.miccroservice.user.service.UserService.service;

import java.util.List;

import com.miccroservice.user.service.UserService.entities.Users;

public interface UserService {

	Users saveUSer(Users user);

	List<Users> getAllUser();

	Users getUser(String userId);

	Users deleteUser(String userId);

	Users updateUser(String userId);

}
