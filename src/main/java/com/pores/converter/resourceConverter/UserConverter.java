package com.pores.converter.resourceConverter;

import com.pores.entities.PoresUser;
import com.pores.resource.UserResource;

public class UserConverter {

    public static PoresUser convert(UserResource resource){
    return PoresUser.builder()
            .contactNumber(resource.getContactNumber())
            .email(resource.getEmail())
            .ref(resource.getRef())
            .dateOfBirth(resource.getDateOfBirth())
            .firstName(resource.getFirstName())
            .lastName(resource.getLastName())
            .emailPreference(resource.isEmailPreference())
            .profile(ProfileConverter.convert(resource.getProfileResource()))
            .username(resource.getUsername())
            .build();
    }

    public static UserResource convert(PoresUser user){
        return UserResource.builder().build();
    }
}
