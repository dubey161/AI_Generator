package com.example.generated.mappedCharacterRequest.api;

import java.time.Instant;
import java.util.UUID;

public record MappedCharacterRequestResponse(
        UUID id,
        String words,
        String weights,
        Instant createdAt,
        Instant updatedAt
) {
    public static MappedCharacterRequestResponse from(MappedCharacterRequest entity) {
        return new MappedCharacterRequestResponse(
                entity.getId(),
                entity.getWords(),
                entity.getWeights(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
