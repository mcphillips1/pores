package com.pores.database.repository;

import com.pores.entities.PoresUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<PoresUser, Long> {

    PoresUser findByUsername(String username);
    PoresUser findByRef(String ref);
    PoresUser findByFirstName(String username, String firstName);
}
