package com.example.generated.word.domain;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "words")
public class Word {

    @Id
    private UUID id;

    @Column(nullable = false)
    private String word;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @Version
    private long version;

    protected Word() {}

    private Word(UUID id, String word, Instant createdAt) {
        this.id = id;
        this.word = word;
        this.createdAt = createdAt;
        this.updatedAt = createdAt;
    }

    public static Word create(String word) {
        return new Word(UUID.randomUUID(),
                word, Instant.now());
    }

    public UUID getId() { return id; }
    public Instant getCreatedAt() { return createdAt; }
    public Instant getUpdatedAt() { return updatedAt; }
    public String getWord() { return word; }
}
