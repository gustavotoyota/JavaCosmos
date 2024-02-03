package com.javacosmos.database.hibernate.model;

import com.javacosmos.database.hibernate.dtos.UserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "users")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {
  @Id
  @GeneratedValue
  @Column(columnDefinition = "UUID")
  private String id;

  @Column(columnDefinition = "TEXT", nullable = false)
  private String username;

  @Column(columnDefinition = "TEXT", nullable = false)
  private String password;

  public User(UserDTO userDTO) {
    this.username = userDTO.username();
  }
}
