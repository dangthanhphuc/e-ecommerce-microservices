package org.microservices.user_service.services;

import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.*;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.microservices.user_service.dto.ResetPassword;
import org.microservices.user_service.dto.UserRegistrationRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class KeycloakUserServiceImpl implements KeycloakUserService{

    private final Keycloak keycloak;

    @Value("${keycloak.realm}")
    private String realm;


    @Override
    public UserRegistrationRecord createUser(UserRegistrationRecord userRegistrationRecord) {

        UserRepresentation user = new UserRepresentation();
        user.setEnabled(true);
        user.setUsername(userRegistrationRecord.username());
        user.setEmail(userRegistrationRecord.email());
        user.setFirstName(userRegistrationRecord.firstName());
        user.setLastName(userRegistrationRecord.lastName());
        user.setEmailVerified(false);

        CredentialRepresentation credential = new CredentialRepresentation();
        credential.setValue(userRegistrationRecord.password());
        credential.setTemporary(false);
        credential.setType(CredentialRepresentation.PASSWORD);

        List<CredentialRepresentation> credentials = new ArrayList<>();
        credentials.add(credential);

        user.setCredentials(credentials);

        UsersResource userResource = getUsersResource(); // Get the UsersResource from realm of keycloak

        // Create the user in realm
        Response response = userResource.create(user);

        if(Objects.equals(201, response.getStatus())){
            List<UserRepresentation> representationList = userResource.search(userRegistrationRecord.username(), true);
            if(!CollectionUtils.isEmpty(representationList)){
                UserRepresentation userRepresentation = representationList.stream()
                        .filter(userRepresentation1 ->
                                Objects.equals(false, userRepresentation1.isEmailVerified())
                        ).findFirst().orElse(null);
//                assert userRepresentation != null;
//                emailVerification(userRepresentation.getId());
            }
            return userRegistrationRecord;
        }
        return null;
    }

    private UsersResource getUsersResource() {
        RealmResource realm1 = keycloak.realm(realm);
        return realm1.users();
    }


    @Override
    public UserRepresentation getUserById(String userId) {
        return getUsersResource().get(userId).toRepresentation();
    }

    @Override
    public void deleteUserById(String userId) {
        getUsersResource().delete(userId);
    }

    @Override
    public void emailVerification(String userId) {
        UsersResource usersResource = getUsersResource();
        usersResource.get(userId).sendVerifyEmail();
    }

    @Override
    public UserResource getUserResource(String userId){
        UsersResource usersResource = getUsersResource();
        return usersResource.get(userId);
    }

    @Override
    public void updatePassword(String userId) {
        UserResource userResource = getUserResource(userId);
        List<String> actions= new ArrayList<>();
        actions.add("UPDATE_PASSWORD");
        userResource.executeActionsEmail(actions);
    }

    @Override
    public void updatePassword(ResetPassword resetPassword, String userId) {
        UserResource userResource = getUserResource(userId);
        CredentialRepresentation credentialRepresentation=new CredentialRepresentation();
        credentialRepresentation.setValue(resetPassword.password());
        credentialRepresentation.setType(CredentialRepresentation.PASSWORD);
        credentialRepresentation.setTemporary(false);
        userResource.resetPassword(credentialRepresentation);
    }

    @Override
    public void assignRole(String userId, String roleName) {
        UserResource userResource = getUserResource(userId);
        RolesResource rolesResource = getRolesResource();
        RoleRepresentation role = rolesResource.get(roleName).toRepresentation();
        // Assign role here
        userResource.roles().realmLevel().add(Collections.singletonList(role));
    }

    private RolesResource getRolesResource(){
        return keycloak.realm(realm).roles();
    }

}
