package com.javacosmos.database.hibernate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface JpaUserRepository extends JpaRepository<JpaUserEntity, String> {
  UserDetails findByUsername(String username);
}
