package com.javacosmos.database.hibernate.dtos;

import java.util.UUID;

public record CategoryDTO(
        String title,
        String description,
        UUID ownerId) {
}
