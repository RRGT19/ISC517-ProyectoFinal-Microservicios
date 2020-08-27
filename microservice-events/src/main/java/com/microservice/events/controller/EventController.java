package com.microservice.events.controller;

import com.microservice.events.model.CreateEventDto;
import com.microservice.events.model.Event;
import com.microservice.events.service.EventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * A {@link RestController} that handles all incoming HTTP requests from the client and returns an appropriate response.
 */
@RestController
// Declares that the url for all the apis in this controller will start with "/users".
// @RequestMapping(value = "/users")
public class EventController {

  // Required dependencies
  private final EventServiceImpl service;

  // Constructor-based dependency injection
  @Autowired
  public EventController(EventServiceImpl service) {
    this.service = service;
  }

  @PostMapping("/create")
  public ResponseEntity<Event> createNewUser(@RequestBody CreateEventDto eventDto) {
    Event newUser = service.create(eventDto);
    return new ResponseEntity<>(newUser, HttpStatus.CREATED);
  }

  @GetMapping("/events")
  public ResponseEntity<List<Event>> findAll() {
    return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
  }

}
