package com.javacosmos.database.mongo.services;

import org.springframework.stereotype.Service;

import com.javacosmos.database.mongo.domain.user.User;
import com.javacosmos.database.mongo.domain.user.UserDTO;
import com.javacosmos.database.mongo.repositories.UserRepository;

@Service
public class UserService {
  private UserRepository repository;

  public UserService(UserRepository repository) {
    this.repository = repository;
  }

  public void create(UserDTO userDTO) {
    repository.save(new User(userDTO));
  }
}
