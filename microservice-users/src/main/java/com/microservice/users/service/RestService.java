package com.microservice.users.service;

import com.microservice.users.model.RequestResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class RestService {

  private final RestTemplate restTemplate;

  public RestService(RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder.build();
  }

  @Async
  public void sendEmail(String to, String subject, String text) {
    String url = "http://localhost:8091/emails/send";

    // create headers
    HttpHeaders headers = new HttpHeaders();
    // set `content-type` header
    headers.setContentType(MediaType.APPLICATION_JSON);
    // set `accept` header
    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

    // create a map for post parameters
    Map<String, Object> map = new HashMap<>();
    map.put("to", to);
    map.put("subject", subject);
    map.put("text", text);

    // build the request
    HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

    // send POST request
    //ResponseEntity<RequestResponse> response = this.restTemplate.postForEntity(url, entity, RequestResponse.class);
    this.restTemplate.postForEntity(url, entity, RequestResponse.class);

    // check response status code
    /*if (response.getStatusCode() == HttpStatus.CREATED) {
      return null;
    } else {
      return null;
    }*/
  }
}
