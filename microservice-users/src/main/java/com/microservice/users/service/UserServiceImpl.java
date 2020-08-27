package com.microservice.users.service;

import com.microservice.users.exception.BadCredentialsException;
import com.microservice.users.exception.ResourceExistsException;
import com.microservice.users.exception.ResourceNotFoundException;
import com.microservice.users.model.LoginDto;
import com.microservice.users.model.Role;
import com.microservice.users.model.User;
import com.microservice.users.repository.RoleRepository;
import com.microservice.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements IUserService {

  // Required dependencies
  private final UserRepository userRepository;
  private final RoleRepository roleRepository;
  private final RestService restService;

  // Constructor-based dependency injection
  @Autowired
  public UserServiceImpl(
          UserRepository userRepository,
          RoleRepository roleRepository,
          RestService restService
  ) {
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
    this.restService = restService;
  }

  @Override
  public User login(LoginDto loginRequest) {
    User currentUser = userRepository.findUserByUsername(loginRequest.username);

    if (currentUser == null)
      throw new ResourceNotFoundException();

    if (loginRequest.password.equals(currentUser.getPassword()))
      return currentUser;
    else
      throw new BadCredentialsException();
  }

  @Override
  public User findUserByUsername(String username) {
    return userRepository.findUserByUsername(username);
  }

  @Override
  public User saveUser(User user) {
    /*User currentUser = userRepository.findUserByUsername(user.getUsername());

    if (currentUser != null)
      throw new ResourceExistsException();*/

    User newUser = new User();
    newUser.setPassword(user.getPassword());
    newUser.setUsername(user.getUsername());
    newUser.setName(user.getName());
    newUser.setEmail(user.getEmail());
    Role userRole = roleRepository.findByRole("CLIENT");
    newUser.setRoles(new HashSet<>(Arrays.asList(userRole)));
    String emailBody = "Usuario: " + user.getUsername() + " - Contraseña: " + user.getPassword() + ". Puedes iniciar sesión en: http://localhost:4200/auth/login";
    restService.sendEmail(user.getEmail(), "Detalles de tu cuenta", "Hola, has creado una cuenta nueva con nosotros. " + emailBody);
    return userRepository.save(newUser);
  }

  @Override
  public List<User> findAll() {
    return userRepository.findAll();
  }

}
