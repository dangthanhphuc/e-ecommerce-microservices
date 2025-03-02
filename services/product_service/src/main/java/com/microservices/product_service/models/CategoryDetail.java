package com.microservices.product_service.models;


import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record CategoryDetail(
        @NotBlank(message = "Name of category detail is required")
        String name,
        String urlImg,
        @Min(value = 1, message = "Quantity must be greater than or equal to 1")
        int quantity
) {
}
