package com.example.generated.word.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface WordRepository extends JpaRepository<Word, UUID> {
}
