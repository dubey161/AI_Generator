package com.example.generated.mappedCharacter.api;

import com.example.generated.mappedCharacter.application.MappedCharacterService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/mapped_characters")
public class MappedCharacterController {

    private final MappedCharacterService service;

    public MappedCharacterController(MappedCharacterService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    MappedCharacterResponse create(@Valid @RequestBody CreateMappedCharacterRequest request) {
        return MappedCharacterResponse.from(service.create(request));
    }

    @GetMapping("/{id}")
    MappedCharacterResponse get(@PathVariable UUID id) {
        return MappedCharacterResponse.from(service.get(id));
    }

    @GetMapping
    List<MappedCharacterResponse> list() {
        return service.list().stream().map(MappedCharacterResponse::from).toList();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
