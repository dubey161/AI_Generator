package com.example.generated.weight.domain;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "weights")
public class Weight {

    @Id
    private UUID id;

    @Column(nullable = false)
    private Integer weight;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @Version
    private long version;

    protected Weight() {}

    private Weight(UUID id, Integer weight, Instant createdAt) {
        this.id = id;
        this.weight = weight;
        this.createdAt = createdAt;
        this.updatedAt = createdAt;
    }

    public static Weight create(Integer weight) {
        return new Weight(UUID.randomUUID(),
                weight, Instant.now());
    }

    public UUID getId() { return id; }
    public Instant getCreatedAt() { return createdAt; }
    public Instant getUpdatedAt() { return updatedAt; }
    public Integer getWeight() { return weight; }
}
