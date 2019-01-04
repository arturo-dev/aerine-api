package com.arturo.aerineapi.game.map;

import java.util.Collection;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.bson.types.ObjectId;

import lombok.Data;
import lombok.Generated;

@Data
@Generated
public class Map {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ObjectId id;
    
    private Collection<MapLayer> layers;

}