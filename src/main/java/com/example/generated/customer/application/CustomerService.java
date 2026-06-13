package com.example.generated.customer.application;

import com.example.generated.customer.domain.Customer;
import com.example.generated.customer.domain.CustomerRepository;
import com.example.generated.customer.api.CreateCustomerRequest;
import com.example.generated.customer.api.CustomerResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Customer create(CreateCustomerRequest request) {
        return repository.save(Customer.create(request.id(), request.email()));
    }

    @Transactional(readOnly = true)
    public Customer get(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found: " + id));
    }

    @Transactional(readOnly = true)
    public List<Customer> list() {
        return repository.findAll();
    }

    @Transactional
    public void delete(UUID id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Customer not found: " + id);
        }
        repository.deleteById(id);
    }
}
