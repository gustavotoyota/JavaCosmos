package com.javacosmos.database.mongo.domain.category;

public record CategoryDTO(
    String title,
    String description,
    String ownerId) {
}
