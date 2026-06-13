package com.example.generated.customer.domain;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    private UUID id;

    @Column(name = "id")
    private UUID id;

    @Column(nullable = false)
    private String email;

    @Column
    private Boolean deleted;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @Version
    private long version;

    protected Customer() {}

    private Customer(UUID id, UUID id, String email, Boolean deleted, Instant createdAt) {
        this.id = id;
        this.id = id;
        this.email = email;
        this.deleted = deleted;
        this.createdAt = createdAt;
        this.updatedAt = createdAt;
    }

    public static Customer create(UUID id, String email) {
        return new Customer(UUID.randomUUID(),
                id,
                email,
                null, Instant.now());
    }

    public UUID getId() { return id; }
    public Instant getCreatedAt() { return createdAt; }
    public Instant getUpdatedAt() { return updatedAt; }
    public UUID getId() { return id; }
    public String getEmail() { return email; }
    public Boolean getDeleted() { return deleted; }
}
