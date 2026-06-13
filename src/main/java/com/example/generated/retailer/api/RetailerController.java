package com.example.generated.retailer.api;

import com.example.generated.retailer.application.RetailerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/retailers")
public class RetailerController {

    private final RetailerService service;

    public RetailerController(RetailerService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    RetailerResponse create(@Valid @RequestBody CreateRetailerRequest request) {
        return RetailerResponse.from(service.create(request));
    }

    @GetMapping("/{id}")
    RetailerResponse get(@PathVariable UUID id) {
        return RetailerResponse.from(service.get(id));
    }

    @GetMapping
    List<RetailerResponse> list() {
        return service.list().stream().map(RetailerResponse::from).toList();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
