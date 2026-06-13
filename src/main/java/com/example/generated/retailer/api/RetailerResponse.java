package com.example.generated.retailer.api;

import java.time.Instant;
import java.util.UUID;

public record RetailerResponse(
        UUID id,
        String name,
        Instant createdAt,
        Instant updatedAt
) {
    public static RetailerResponse from(Retailer entity) {
        return new RetailerResponse(
                entity.getId(),
                entity.getName(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
