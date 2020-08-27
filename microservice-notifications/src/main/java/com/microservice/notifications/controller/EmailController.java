package com.microservice.notifications.controller;

import com.microservice.notifications.model.EmailDto;
import com.microservice.notifications.service.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A {@link RestController} that handles all incoming HTTP requests from the client and returns an appropriate response.
 */
@RestController
// Declares that the url for all the apis in this controller will start with "/users".
@RequestMapping(value = "/emails")
public class EmailController {

  // Required dependencies
  private final EmailServiceImpl service;

  // Constructor-based dependency injection
  @Autowired
  public EmailController(EmailServiceImpl service) {
    this.service = service;
  }

  @PostMapping("/send")
  public void send(@RequestBody EmailDto emailDto) {
    service.sendEmail(emailDto);
  }

}
