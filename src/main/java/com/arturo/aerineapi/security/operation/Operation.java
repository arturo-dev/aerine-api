package com.arturo.aerineapi.security.operation;

import java.util.Collection;

import javax.persistence.Id;

import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Generated
public class Operation {
    @Id private ObjectId id;
    private Collection<ObjectId> alloweds;
}