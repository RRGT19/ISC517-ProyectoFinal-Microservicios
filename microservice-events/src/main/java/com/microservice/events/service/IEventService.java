package com.microservice.events.service;

import com.microservice.events.model.CreateEventDto;
import com.microservice.events.model.Event;

import java.util.List;

public interface IEventService {
  Event create(CreateEventDto createEventDto);

  List<Event> findAll();
}
