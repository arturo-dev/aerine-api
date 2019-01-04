package com.arturo.aerineapi.game.map;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MapRepository extends MongoRepository<Map, ObjectId> {

}
