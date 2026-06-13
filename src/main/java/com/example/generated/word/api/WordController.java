package com.example.generated.word.api;

import com.example.generated.word.application.WordService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/words")
public class WordController {

    private final WordService service;

    public WordController(WordService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    WordResponse create(@Valid @RequestBody CreateWordRequest request) {
        return WordResponse.from(service.create(request));
    }

    @GetMapping("/{id}")
    WordResponse get(@PathVariable UUID id) {
        return WordResponse.from(service.get(id));
    }

    @GetMapping
    List<WordResponse> list() {
        return service.list().stream().map(WordResponse::from).toList();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
