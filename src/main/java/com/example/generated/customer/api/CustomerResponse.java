package com.example.generated.customer.api;

import java.time.Instant;
import java.util.UUID;

public record CustomerResponse(
        UUID id,
        UUID id,
        String email,
        Boolean deleted,
        Instant createdAt,
        Instant updatedAt
) {
    public static CustomerResponse from(Customer entity) {
        return new CustomerResponse(
                entity.getId(),
                entity.getId(),
                entity.getEmail(),
                entity.getDeleted(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
