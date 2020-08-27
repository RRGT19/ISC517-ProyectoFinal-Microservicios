package com.api.gateway.controller;

import com.api.gateway.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Microservice users
 */

/*@FeignClient("microservice-users")
interface IUser {

  @GetMapping("/users")
  @CrossOrigin
  List<User> readUsers();

  @PostMapping("/users/create")
  @CrossOrigin
  User createUser(@RequestBody User user);

}*/

@RestController
public class UserController {

  /*private final IUser userInterface;

  public UserController(IUser userInterface) {
    this.userInterface = userInterface;
  }

  private Collection<User> fallback() {
    return new ArrayList<>();
  }

  @GetMapping("/api/users")
  @CrossOrigin
  // @HystrixCommand(fallbackMethod = "fallback")
  public ResponseEntity<List<User>> readUsers() {
    return new ResponseEntity<>(userInterface.readUsers(), HttpStatus.OK);
  }

  @PostMapping("/api/users/create")
  @CrossOrigin
  // @HystrixCommand(fallbackMethod = "fallback")
  public ResponseEntity<User> createUser(@RequestBody User user) {
    User newUser = userInterface.createUser(user);
    return new ResponseEntity<>(newUser, HttpStatus.CREATED);
  }*/

}
