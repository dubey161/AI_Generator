package com.example.generated.retailer.api;

import jakarta.validation.constraints.*;
import java.util.UUID;

public record CreateRetailerRequest(
        
            @NotBlank @NotNull @Size(max = 255)
            String name
) {}
