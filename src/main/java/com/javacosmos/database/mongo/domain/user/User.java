package com.javacosmos.database.mongo.domain.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
  @Id
  private String id;

  private String username;

  public User(UserDTO userDTO) {
    this.username = userDTO.username();
  }
}
