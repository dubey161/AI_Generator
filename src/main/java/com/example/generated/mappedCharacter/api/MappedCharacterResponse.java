package com.example.generated.mappedCharacter.api;

import java.time.Instant;
import java.util.UUID;

public record MappedCharacterResponse(
        UUID id,
        String character,
        Instant createdAt,
        Instant updatedAt
) {
    public static MappedCharacterResponse from(MappedCharacter entity) {
        return new MappedCharacterResponse(
                entity.getId(),
                entity.getCharacter(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
