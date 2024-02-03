package com.javacosmos.database.hibernate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javacosmos.database.hibernate.model.Category;

public interface HibernateCategoryRepository extends JpaRepository<Category, String> {
}
