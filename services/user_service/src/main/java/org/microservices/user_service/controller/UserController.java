package org.microservices.user_service.controller;

import lombok.RequiredArgsConstructor;
import org.keycloak.representations.idm.UserRepresentation;
import org.microservices.user_service.dto.ResetPassword;
import org.microservices.user_service.dto.UserRegistrationRecord;
import org.microservices.user_service.services.KeycloakUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class UserController {

    private final KeycloakUserService keycloakUserService;


    @PostMapping
    public ResponseEntity<UserRegistrationRecord> createUser(
            @RequestBody UserRegistrationRecord userRegistrationRecord
    ) {
        UserRegistrationRecord createdUser = keycloakUserService.createUser(userRegistrationRecord);
        return ResponseEntity.ok().body(createdUser);
    }

    @GetMapping
    public ResponseEntity<UserRepresentation> getUser(Principal principal) {
        return ResponseEntity.ok().body(
                keycloakUserService.getUserById(principal.getName())
        );
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<Void> deleteUserById(
            @PathVariable String userId
    ) {
        keycloakUserService.deleteUserById(userId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{userId}/send-verify-email")
    public void sendVerificationEmail(@PathVariable String userId) {
        keycloakUserService.emailVerification(userId);
    }

    @PutMapping("/update-password")
    public void updatePassword(Principal principal) {
        keycloakUserService.updatePassword(principal.getName());
    }

    @PutMapping("/change-password")
    public void updatePassword(@RequestBody ResetPassword request, Principal principal) {
        keycloakUserService.updatePassword(request, principal.getName());
    }

    @PutMapping("/assign-role/user/{userId}")
    public ResponseEntity<String> assignRole(
            @PathVariable String userId,
            @RequestParam String roleName)
    {
        keycloakUserService.assignRole(userId, roleName);
        return ResponseEntity.ok().body("Role assigned successfully");
    }

}
