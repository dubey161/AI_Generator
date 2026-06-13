package com.example.generated.word.api;

import jakarta.validation.constraints.*;
import java.util.UUID;

public record CreateWordRequest(
        
            @NotBlank @NotNull @Pattern(regexp = "^[a-zA-Z0-9]+$") @Size(max = 10)
            String word
) {}
