package com.javacosmos.database.mongo.dtos;

public record ProductDTO(
        String title,
        String description,
        String ownerId,
        Integer price,
        String categoryId) {

}
