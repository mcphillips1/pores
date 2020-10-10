package com.pores.service.impl;

import com.pores.common.EncryptionSalt;
import com.pores.converter.resourceConverter.ProfileConverter;
import com.pores.database.IDGenerator;
import com.pores.database.repository.UserRepo;
import com.pores.entities.PoresUser;
import com.pores.entities.Profile;
import com.pores.resource.ProfileResource;
import com.pores.resource.UserResource;
import com.pores.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.FindAndReplaceOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.pores.converter.resourceConverter.UserConverter.convert;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final IDGenerator generator;
    private final UserRepo repo;
    private final MongoOperations operations;


    @Override
    public UserResource register(UserResource user) {
        String salt = EncryptionSalt.generateSalt(7).get();
        PoresUser poresUser = convert(user);
        poresUser.setId(generator.generateSequence(PoresUser.getSeqName()));
        poresUser.setRef(generator.generateTextSequence(poresUser.getLastName()));
        poresUser.setSalt(salt);
        poresUser.setSaltedPassword(EncryptionSalt.hashPassword(user.getPassword(), salt).get());
        poresUser.setProfile(
                Profile.builder()
                        .id(generator.generateSequence(Profile.seqName))
                        .ref(poresUser.getRef())
                        .build()
        );
        repo.save(poresUser);
        return UserResource.builder()
                .ref(poresUser.getRef())
                .build();
    }

    @Override
    public UserResource authenticateUser(UserResource resource) {
        PoresUser poresUser = convert(resource);
        PoresUser storedUser = repo.findByUsername(poresUser.getUsername());
        Boolean passVerfied = EncryptionSalt.verifyPassword(resource.getPassword(), storedUser.getSaltedPassword(), storedUser.getSalt());
        return passVerfied ? UserResource.builder()
                .username(storedUser.getUsername())
                .build() : UserResource.builder().build();
    }

    @Override
    public UserResource getUserAccount(String ref) {
        PoresUser user = repo.findByRef(ref);
        if(Objects.isNull(user)){
            //return userNotFound;
        }




        return null;
    }

    @Override
    public String storeUserImageProfile(byte[] imageUpload) {
        return null;
    }

    @Override
    public ProfileResource editUserProfile(String ref, ProfileResource resource) {
        Profile profile = ProfileConverter.convert(resource);
        operations.update(Profile.class)
                .matching(query(where("ref").is(ref)))
                .replaceWith(profile)
                .withOptions(FindAndReplaceOptions.options().upsert())
                .findAndReplace();

        return ProfileResource.builder()
                .ref(profile.getRef())
                .build();
    }
}
