package com.example.generated.mappedCharacterRequest.api;

import com.example.generated.mappedCharacterRequest.application.MappedCharacterRequestService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/mapped_character_requests")
public class MappedCharacterRequestController {

    private final MappedCharacterRequestService service;

    public MappedCharacterRequestController(MappedCharacterRequestService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    MappedCharacterRequestResponse create(@Valid @RequestBody CreateMappedCharacterRequestRequest request) {
        return MappedCharacterRequestResponse.from(service.create(request));
    }

    @GetMapping("/{id}")
    MappedCharacterRequestResponse get(@PathVariable UUID id) {
        return MappedCharacterRequestResponse.from(service.get(id));
    }

    @GetMapping
    List<MappedCharacterRequestResponse> list() {
        return service.list().stream().map(MappedCharacterRequestResponse::from).toList();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
