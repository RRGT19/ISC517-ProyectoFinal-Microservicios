package com.microservice.users.service;

import com.microservice.users.model.LoginDto;
import com.microservice.users.model.User;

import java.util.List;

public interface IUserService {
  User findUserByUsername(String username);
  User saveUser(User user);
  User login(LoginDto loginRequest);
  List<User> findAll();
}
