package com.example.generated.weight.api;

import com.example.generated.weight.application.WeightService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/weights")
public class WeightController {

    private final WeightService service;

    public WeightController(WeightService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    WeightResponse create(@Valid @RequestBody CreateWeightRequest request) {
        return WeightResponse.from(service.create(request));
    }

    @GetMapping("/{id}")
    WeightResponse get(@PathVariable UUID id) {
        return WeightResponse.from(service.get(id));
    }

    @GetMapping
    List<WeightResponse> list() {
        return service.list().stream().map(WeightResponse::from).toList();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
