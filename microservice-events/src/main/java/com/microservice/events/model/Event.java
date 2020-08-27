package com.microservice.events.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "events")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "event_id"))
})
public class Event extends BaseEntity {

  private String name;
  private int serviceNumber;
  private int cost;
  private int userId;
  private String userEmail;

  public Event() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getServiceNumber() {
    return serviceNumber;
  }

  public void setServiceNumber(int serviceNumber) {
    this.serviceNumber = serviceNumber;
  }

  public int getCost() {
    return cost;
  }

  public void setCost(int cost) {
    this.cost = cost;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }
}
