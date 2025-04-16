package org.microservices.user_service.services;

import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.UserRepresentation;
import org.microservices.user_service.dto.ResetPassword;
import org.microservices.user_service.dto.UserRegistrationRecord;

public interface KeycloakUserService {

    UserRegistrationRecord createUser(UserRegistrationRecord userRegistrationRecord);
    UserRepresentation getUserById(String userId); // UserRepresentation is a Keycloak class that represents a user information
    void deleteUserById(String userId);
    void emailVerification(String userId);
    UserResource getUserResource(String userId);
    void updatePassword(String userId);
    void updatePassword(ResetPassword resetPassword, String userId);

    void assignRole(String userId, String roleName);

}
