package com.javacosmos.database.mongo.services;

import org.springframework.stereotype.Service;

import com.javacosmos.database.mongo.dtos.UserDTO;
import com.javacosmos.database.mongo.model.User;
import com.javacosmos.database.mongo.repositories.MongoUserRepository;

@Service
public class MongoUserService {
  private MongoUserRepository repository;

  public MongoUserService(MongoUserRepository repository) {
    this.repository = repository;
  }

  public void create(UserDTO userDTO) {
    repository.save(new User(userDTO));
  }
}
