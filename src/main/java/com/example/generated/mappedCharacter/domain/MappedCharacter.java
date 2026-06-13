package com.example.generated.mappedCharacter.domain;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "mapped_characters")
public class MappedCharacter {

    @Id
    private UUID id;

    @Column(nullable = false)
    private String character;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @Version
    private long version;

    protected MappedCharacter() {}

    private MappedCharacter(UUID id, String character, Instant createdAt) {
        this.id = id;
        this.character = character;
        this.createdAt = createdAt;
        this.updatedAt = createdAt;
    }

    public static MappedCharacter create(String character) {
        return new MappedCharacter(UUID.randomUUID(),
                character, Instant.now());
    }

    public UUID getId() { return id; }
    public Instant getCreatedAt() { return createdAt; }
    public Instant getUpdatedAt() { return updatedAt; }
    public String getCharacter() { return character; }
}
