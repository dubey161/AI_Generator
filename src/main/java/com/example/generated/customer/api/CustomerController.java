package com.example.generated.customer.api;

import com.example.generated.customer.application.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    CustomerResponse create(@Valid @RequestBody CreateCustomerRequest request) {
        return CustomerResponse.from(service.create(request));
    }

    @GetMapping("/{id}")
    CustomerResponse get(@PathVariable UUID id) {
        return CustomerResponse.from(service.get(id));
    }

    @GetMapping
    List<CustomerResponse> list() {
        return service.list().stream().map(CustomerResponse::from).toList();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
