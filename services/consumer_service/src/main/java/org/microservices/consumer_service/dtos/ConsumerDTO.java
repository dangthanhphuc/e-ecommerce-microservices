package org.microservices.consumer_service.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import org.microservices.consumer_service.anotations.MinAge;

import java.time.LocalDate;

/**
 * Data Transfer Object representing a consumer in the system.
 * <p>
 * This record encapsulates consumer information with validation constraints:
 * <ul>
 *   <li>name: Must be between 8 and 50 characters</li>
 *   <li>phoneNumber: Phone contact information</li>
 *   <li>email: Must be a valid email format between 10 and 100 characters</li>
 *   <li>gender: Required boolean field (true for male, false for female)</li>
 *   <li>dob: Date of birth, consumer must be at least 18 years old</li>
 * </ul>
 */
public record ConsumerDTO(
        @Size(min = 8, max = 50, message = "Name must be between 8 and 50 characters !")
        String name,
        @JsonProperty("phone_number")
        String phoneNumber,
        @Email(message = "Invalid email format!")
        @Size(min = 10, max = 100, message = "Phone number must be between 10 and 15 digits !")
        String email,
        @NotNull(message = "Gender is required!")
        Boolean gender,
        @MinAge(value = 18, message = "Age must be at least 18!")
        LocalDate dob
) {
}
