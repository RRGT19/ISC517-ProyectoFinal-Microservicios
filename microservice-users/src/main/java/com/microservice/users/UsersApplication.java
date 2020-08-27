package com.microservice.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableJpaAuditing
@EnableEurekaClient
@SpringBootApplication
@EnableAsync
public class UsersApplication {

  public static void main(String[] args) {
    SpringApplication.run(UsersApplication.class, args);
  }

}
