package com.arturo.aerineapi.game.server;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Generated
public class Server {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private ObjectId id;

    private String name;

}