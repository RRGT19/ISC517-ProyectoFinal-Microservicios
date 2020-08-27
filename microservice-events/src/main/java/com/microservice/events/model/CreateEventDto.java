package com.microservice.events.model;

public class CreateEventDto {
  private int serviceNumber;
  private int cost;
  private int userId;
  private String userEmail;

  public CreateEventDto(int serviceNumber, int cost, int userId, String userEmail) {
    this.serviceNumber = serviceNumber;
    this.cost = cost;
    this.userId = userId;
    this.userEmail = userEmail;
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
