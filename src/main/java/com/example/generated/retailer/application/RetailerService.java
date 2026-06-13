package com.example.generated.retailer.application;

import com.example.generated.retailer.domain.Retailer;
import com.example.generated.retailer.domain.RetailerRepository;
import com.example.generated.retailer.api.CreateRetailerRequest;
import com.example.generated.retailer.api.RetailerResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class RetailerService {

    private final RetailerRepository repository;

    public RetailerService(RetailerRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Retailer create(CreateRetailerRequest request) {
        return repository.save(Retailer.create(request.name()));
    }

    @Transactional(readOnly = true)
    public Retailer get(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Retailer not found: " + id));
    }

    @Transactional(readOnly = true)
    public List<Retailer> list() {
        return repository.findAll();
    }

    @Transactional
    public void delete(UUID id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Retailer not found: " + id);
        }
        repository.deleteById(id);
    }
}
