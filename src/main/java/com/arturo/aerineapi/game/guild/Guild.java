package com.arturo.aerineapi.game.guild;

import java.util.Collection;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.arturo.aerineapi.game.player.Player;

import org.springframework.data.mongodb.core.mapping.DBRef;

import lombok.Data;
import lombok.Generated;

@Data
@Generated
public class Guild {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String name;
    private String description;

    @DBRef
    private Player master;

    @DBRef
    private Collection<Player> members;

    @DBRef
    private Collection<Player> join;

}