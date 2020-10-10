package com.pores.service;

import com.pores.resource.ProfileResource;
import com.pores.resource.UserResource;

public interface UserService {
    UserResource register(UserResource user);

    UserResource authenticateUser(UserResource resource);

    UserResource getUserAccount(String ref);

    String storeUserImageProfile(byte[] imageUpload);

    ProfileResource editUserProfile(String ref, ProfileResource resource);
}
