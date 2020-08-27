package com.microservice.notifications.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class GmailConfig {

  @Bean("gmail")
  public JavaMailSender getJavaMailSender() {
    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    mailSender.setHost("smtp.gmail.com");
    mailSender.setPort(465);

    mailSender.setUsername("EMAIL");
    mailSender.setPassword("PASSWORD");

    mailSender.setJavaMailProperties(getMailProperties());

    return mailSender;
  }

  private Properties getMailProperties() {
    Properties properties = new Properties();
    properties.setProperty("mail.transport.protocol", "smtp");
    properties.setProperty("mail.smtp.auth", "true");
    properties.setProperty("mail.smtp.starttls.enable", "true");
    properties.setProperty("mail.debug", "true");
    properties.setProperty("mail.smtp.ssl.enable","true");
    properties.setProperty("mail.test-connection","true");
    return properties;
  }

}