package com.example.generated.customer.api;

import jakarta.validation.constraints.*;
import java.util.UUID;

public record CreateCustomerRequest(
        
            @NotBlank
            UUID id,
        
            @NotBlank @Email @NotNull
            String email
) {}
