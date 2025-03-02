package com.microservices.product_service.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.microservices.product_service.models.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.util.List;

/**
 *  @param name The name of the product
 *  @param price The price of the product
 *  @param desc A detailed description of the product
 *  @param categories The categories to which the product belongs, separated by commas
 *  @param supplierId The unique identifier of the supplier of the product
 */
public record ProductDTO(
        @NotBlank(message = "Name of product is required")
        String name,
        @Positive(message = "Price must be positive")
        float price,
        String desc,
        List<Category> categories,
        @JsonProperty("supplier_id")
        @NotBlank(message = "Supplier ID is required")
        String supplierId
) {
}
