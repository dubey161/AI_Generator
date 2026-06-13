package com.example.generated.mappedCharacter.api;

import jakarta.validation.constraints.*;
import java.util.UUID;

public record CreateMappedCharacterRequest(
        
            @NotBlank
            String character
) {}
