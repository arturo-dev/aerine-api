package com.arturo.aerineapi.game.server;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface ServerRepository extends MongoRepository<Server, ObjectId> {

    Server findOneByName(String name);

}