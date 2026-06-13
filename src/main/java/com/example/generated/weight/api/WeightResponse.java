package com.example.generated.weight.api;

import java.time.Instant;
import java.util.UUID;

public record WeightResponse(
        UUID id,
        Integer weight,
        Instant createdAt,
        Instant updatedAt
) {
    public static WeightResponse from(Weight entity) {
        return new WeightResponse(
                entity.getId(),
                entity.getWeight(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
