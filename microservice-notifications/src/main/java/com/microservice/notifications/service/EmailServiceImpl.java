package com.microservice.notifications.service;

import com.microservice.notifications.model.EmailDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements IEmailService {

  private static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

  // Required dependencies
  private final JavaMailSender emailSender;

  // Constructor-based dependency injection
  @Autowired
  public EmailServiceImpl(
          @Qualifier("gmail") JavaMailSender emailSender
  ) {
    this.emailSender = emailSender;
  }

  @Override
  public void sendEmail(EmailDto emailDto) {
    send(emailDto.getTo(), emailDto.getSubject(), emailDto.getText());
  }

  private boolean send(String to, String subject, String text) {
    boolean send = false;
    MimeMessage message = emailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message);
    try {
      helper.setTo(to);
      helper.setText(text, true);
      helper.setSubject(subject);
      emailSender.send(message);
      send = true;
      logger.info("Mail enviado!");
    } catch (MessagingException e) {
      logger.error("Hubo un error al enviar el mail: {}", e);
    }
    return send;
  }

}
