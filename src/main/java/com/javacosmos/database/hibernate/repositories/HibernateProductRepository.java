package com.javacosmos.database.hibernate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javacosmos.database.hibernate.model.Product;

public interface HibernateProductRepository extends JpaRepository<Product, String> {
}
