package com.api.gateway.model;

import java.util.Date;
import java.util.Set;

public class User {

  private Long id;
  private Date createdAt;
  private String username;
  private String password;
  private String name;
  private String email;
  private Set<Role> roles;

  public User(Long id, Date createdAt, String username, String password, String name, String email, Set<Role> roles) {
    this.id = id;
    this.createdAt = createdAt;
    this.username = username;
    this.password = password;
    this.name = name;
    this.email = email;
    this.roles = roles;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }
}
