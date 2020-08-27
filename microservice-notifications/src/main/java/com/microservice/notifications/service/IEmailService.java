package com.microservice.notifications.service;

import com.microservice.notifications.model.EmailDto;

public interface IEmailService {
  void sendEmail(EmailDto emailDto);
}
