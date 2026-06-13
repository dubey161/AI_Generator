package com.example.generated.word.application;

import com.example.generated.word.domain.Word;
import com.example.generated.word.domain.WordRepository;
import com.example.generated.word.api.CreateWordRequest;
import com.example.generated.word.api.WordResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class WordService {

    private final WordRepository repository;

    public WordService(WordRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Word create(CreateWordRequest request) {
        return repository.save(Word.create(request.word()));
    }

    @Transactional(readOnly = true)
    public Word get(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Word not found: " + id));
    }

    @Transactional(readOnly = true)
    public List<Word> list() {
        return repository.findAll();
    }

    @Transactional
    public void delete(UUID id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Word not found: " + id);
        }
        repository.deleteById(id);
    }
}
