package com.example.generated.mappedCharacterRequest.api;

import jakarta.validation.constraints.*;
import java.util.UUID;

public record CreateMappedCharacterRequestRequest(
        
            @NotBlank @NotNull @Pattern(regexp = "^[a-z]+$")
            String words,
        
            @NotBlank @NotNull
            String weights
) {}
