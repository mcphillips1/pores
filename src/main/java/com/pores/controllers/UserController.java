package com.pores.controllers;

import com.pores.resource.ProfileResource;
import com.pores.resource.UserResource;
import com.pores.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    //Register a new user
    @PostMapping("/register")
    public ResponseEntity<String> registerNewUser(@RequestBody UserResource user) throws Exception {
        UserResource nUser = userService.register(user);
        return ResponseEntity.ok().build();
    }

    // login user
    @PostMapping("/login")
    public ResponseEntity<UserResource> loginToApp(@RequestBody UserResource resource) throws Exception {
        return ResponseEntity.ok(userService.authenticateUser(resource));
    }

    //edit user account
    @PostMapping("/profile")
    public ResponseEntity<ProfileResource> editUserProfile(@RequestParam String ref, @RequestBody ProfileResource resource){
        ProfileResource response = userService.editUserProfile(ref, resource);
        return ResponseEntity.ok(response);
    }

    //get userProfile
    @GetMapping("/profile")
    public ResponseEntity<UserResource> getUserProfile(@RequestParam String ref){
        return null;
    }

    //get user account
    @GetMapping("/account")
    public ResponseEntity<UserResource> getUserAccount(@RequestParam String ref){
        return ResponseEntity.ok(userService.getUserAccount(ref));
    }
}
