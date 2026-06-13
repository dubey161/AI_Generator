package com.example.generated.mappedCharacterRequest.domain;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "mapped_character_requests")
public class MappedCharacterRequest {

    @Id
    private UUID id;

    @Column(nullable = false)
    private String words;

    @Column(nullable = false)
    private String weights;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @Version
    private long version;

    protected MappedCharacterRequest() {}

    private MappedCharacterRequest(UUID id, String words, String weights, Instant createdAt) {
        this.id = id;
        this.words = words;
        this.weights = weights;
        this.createdAt = createdAt;
        this.updatedAt = createdAt;
    }

    public static MappedCharacterRequest create(String words, String weights) {
        return new MappedCharacterRequest(UUID.randomUUID(),
                words,
                weights, Instant.now());
    }

    public UUID getId() { return id; }
    public Instant getCreatedAt() { return createdAt; }
    public Instant getUpdatedAt() { return updatedAt; }
    public String getWords() { return words; }
    public String getWeights() { return weights; }
}
