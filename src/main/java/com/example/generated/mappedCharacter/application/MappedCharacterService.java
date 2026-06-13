package com.example.generated.mappedCharacter.application;

import com.example.generated.mappedCharacter.domain.MappedCharacter;
import com.example.generated.mappedCharacter.domain.MappedCharacterRepository;
import com.example.generated.mappedCharacter.api.CreateMappedCharacterRequest;
import com.example.generated.mappedCharacter.api.MappedCharacterResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class MappedCharacterService {

    private final MappedCharacterRepository repository;

    public MappedCharacterService(MappedCharacterRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public MappedCharacter create(CreateMappedCharacterRequest request) {
        return repository.save(MappedCharacter.create(request.character()));
    }

    @Transactional(readOnly = true)
    public MappedCharacter get(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("MappedCharacter not found: " + id));
    }

    @Transactional(readOnly = true)
    public List<MappedCharacter> list() {
        return repository.findAll();
    }

    @Transactional
    public void delete(UUID id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("MappedCharacter not found: " + id);
        }
        repository.deleteById(id);
    }
}
