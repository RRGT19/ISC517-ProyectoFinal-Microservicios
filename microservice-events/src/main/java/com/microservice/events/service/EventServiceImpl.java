package com.microservice.events.service;

import com.microservice.events.model.CreateEventDto;
import com.microservice.events.model.Event;
import com.microservice.events.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements IEventService {

  // Required dependencies
  private final EventRepository eventRepository;
  private final RestService restService;

  // Constructor-based dependency injection
  @Autowired
  public EventServiceImpl(
          EventRepository eventRepository,
          RestService restService
  ) {
    this.eventRepository = eventRepository;
    this.restService = restService;
  }

  @Override
  public Event create(CreateEventDto createEventDto) {
    Event event = new Event();
    event.setCost(createEventDto.getCost());
    event.setServiceNumber(createEventDto.getServiceNumber());
    event.setUserId(createEventDto.getUserId());
    event.setUserEmail(createEventDto.getUserEmail());

    if (createEventDto.getServiceNumber() == 1) {
      event.setName("Pre-Boda");
    } else if (createEventDto.getServiceNumber() == 2) {
      event.setName("Cumpleaños");
    } else if (createEventDto.getServiceNumber() == 3) {
      event.setName("Video");
    } else {
      event.setName("Boda");
    }


    sendEmailToClient(event);
    return eventRepository.save(event);
  }

  @Override
  public List<Event> findAll() {
    return eventRepository.findAll();
  }

  private void sendEmailToClient(Event event) {
    String emailBody = "Hola, su servicio de " + event.getName() + " ha sido registrado por un monto de RD$" + event.getCost() + ".";
    restService.sendEmail(event.getUserEmail(), "Detalles de tu orden", emailBody);
  }

}
