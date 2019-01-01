package com.arturo.aerineapi.security.operation;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(exported = false)
public interface OperationRepository extends MongoRepository<Operation, ObjectId> {
    
    Boolean existsByIdAndAlloweds(ObjectId id, ObjectId alloweds);

}