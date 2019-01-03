package com.arturo.aerineapi.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface UserRepository extends MongoRepository<User, String> {
    
    User findOneByUsername(String username);
    
}