package com.arturo.aerineapi.game.player;

import java.util.Collection;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.arturo.aerineapi.game.guild.Guild;
import com.arturo.aerineapi.game.village.Village;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;

import lombok.Data;
import lombok.Generated;

@Data
@Generated
public class Player {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private ObjectId id;

    private PlayerResources resources;

    @DBRef
    private Guild guild;
    
    @DBRef
    private Collection<Village> villages;

}