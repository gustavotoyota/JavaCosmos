package com.javacosmos.database.hibernate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.javacosmos.database.hibernate.model.User;

public interface HibernateUserRepository extends JpaRepository<User, String> {
  UserDetails findByUsername(String username);
}
