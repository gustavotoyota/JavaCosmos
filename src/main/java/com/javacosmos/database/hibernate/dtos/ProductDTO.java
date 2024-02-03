package com.javacosmos.database.hibernate.dtos;

import java.util.UUID;

public record ProductDTO(
        String title,
        String description,
        UUID ownerId,
        Integer price,
        UUID categoryId) {
}
