package com.example.generated.word.api;

import java.time.Instant;
import java.util.UUID;

public record WordResponse(
        UUID id,
        String word,
        Instant createdAt,
        Instant updatedAt
) {
    public static WordResponse from(Word entity) {
        return new WordResponse(
                entity.getId(),
                entity.getWord(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
