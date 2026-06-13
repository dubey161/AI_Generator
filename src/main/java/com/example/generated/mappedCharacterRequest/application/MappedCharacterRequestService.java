package com.example.generated.mappedCharacterRequest.application;

import com.example.generated.mappedCharacterRequest.domain.MappedCharacterRequest;
import com.example.generated.mappedCharacterRequest.domain.MappedCharacterRequestRepository;
import com.example.generated.mappedCharacterRequest.api.CreateMappedCharacterRequestRequest;
import com.example.generated.mappedCharacterRequest.api.MappedCharacterRequestResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class MappedCharacterRequestService {

    private final MappedCharacterRequestRepository repository;

    public MappedCharacterRequestService(MappedCharacterRequestRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public MappedCharacterRequest create(CreateMappedCharacterRequestRequest request) {
        return repository.save(MappedCharacterRequest.create(request.words(), request.weights()));
    }

    @Transactional(readOnly = true)
    public MappedCharacterRequest get(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("MappedCharacterRequest not found: " + id));
    }

    @Transactional(readOnly = true)
    public List<MappedCharacterRequest> list() {
        return repository.findAll();
    }

    @Transactional
    public void delete(UUID id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("MappedCharacterRequest not found: " + id);
        }
        repository.deleteById(id);
    }
}
