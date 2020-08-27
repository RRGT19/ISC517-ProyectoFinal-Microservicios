package com.microservice.users.controller;

import com.microservice.users.model.LoginDto;
import com.microservice.users.model.User;
import com.microservice.users.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * A {@link RestController} that handles all incoming HTTP requests from the client and returns an appropriate response.
 */
@RestController
// Declares that the url for all the apis in this controller will start with "/users".
// @RequestMapping(value = "/users")
public class UserController {

  // Required dependencies
  private final UserServiceImpl service;

  // Constructor-based dependency injection
  @Autowired
  public UserController(UserServiceImpl service) {
    this.service = service;
  }

  @PostMapping("/login")
  public ResponseEntity<User> login(@RequestBody LoginDto loginRequest) {
    User user = service.login(loginRequest);
    return new ResponseEntity<>(user, HttpStatus.OK);
  }

  @PostMapping("/create")
  public ResponseEntity<User> createNewUser(@RequestBody User user) {
    User newUser = service.saveUser(user);
    return new ResponseEntity<>(newUser, HttpStatus.CREATED);
  }

  @GetMapping("/users")
  public ResponseEntity<List<User>> findAll() {
    return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
  }

}
