package com.javacosmos.database.mongo.dtos;

public record CategoryDTO(
        String title,
        String description,
        String ownerId) {
}
