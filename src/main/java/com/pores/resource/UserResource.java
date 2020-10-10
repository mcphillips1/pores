package com.pores.resource;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class UserResource {

    String contactNumber;
    String ref;
    String email;
    String firstName;
    String lastName;
    boolean emailPreference;
    LocalDate dateOfBirth;
    String username;
    String password;
    ProfileResource profileResource;
}
