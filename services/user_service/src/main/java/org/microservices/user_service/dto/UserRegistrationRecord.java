package org.microservices.user_service.dto;

public record UserRegistrationRecord(
        String username,
        String password,
        String firstName,
        String lastName,
        String email
) {
}
