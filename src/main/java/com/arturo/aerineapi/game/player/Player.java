package com.arturo.aerineapi.game.player;

import java.util.Collection;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.arturo.aerineapi.game.guild.Guild;
import com.arturo.aerineapi.game.server.Server;
import com.arturo.aerineapi.game.village.Village;
import com.arturo.aerineapi.user.User;

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

    private String name;
    
    private Integer level;

    @DBRef(lazy = true)
    private User user;

    @DBRef(lazy = true)
    @NotNull(message = "Player.Server.Required")
    private Server server;

    @DBRef(lazy = true)
    private Guild guild;
    
    @DBRef(lazy = true)
    private Collection<Village> villages;

}