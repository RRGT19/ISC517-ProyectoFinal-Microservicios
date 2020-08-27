package com.microservice.users.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "user_id"))
})
public class User extends BaseEntity {

  private String username;
  private String password;
  private String name;
  private String email;

  @JsonIgnoreProperties("id")
  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
          name = "user_role",
          joinColumns = @JoinColumn(name = "user_id"),
          inverseJoinColumns = @JoinColumn(name = "role_id")
  )
  private Set<Role> roles;

  public User() {
  }

  public User(String username, String password, String name, String email, Set<Role> roles) {
    this.username = username;
    this.password = password;
    this.name = name;
    this.email = email;
    this.roles = roles;
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

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
