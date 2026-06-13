package com.example.generated.weight.application;

import com.example.generated.weight.domain.Weight;
import com.example.generated.weight.domain.WeightRepository;
import com.example.generated.weight.api.CreateWeightRequest;
import com.example.generated.weight.api.WeightResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class WeightService {

    private final WeightRepository repository;

    public WeightService(WeightRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Weight create(CreateWeightRequest request) {
        return repository.save(Weight.create(request.weight()));
    }

    @Transactional(readOnly = true)
    public Weight get(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Weight not found: " + id));
    }

    @Transactional(readOnly = true)
    public List<Weight> list() {
        return repository.findAll();
    }

    @Transactional
    public void delete(UUID id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Weight not found: " + id);
        }
        repository.deleteById(id);
    }
}
