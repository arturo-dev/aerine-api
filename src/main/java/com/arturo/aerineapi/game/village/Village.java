package com.arturo.aerineapi.game.village;

import java.util.Collection;

import com.arturo.aerineapi.game.build.Build;
import com.arturo.aerineapi.game.player.Player;
import com.sun.istack.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import lombok.Data;
import lombok.Generated;

@Data
@Generated
public class Village {

    @Id
    private String id;

    private String name;
    
    @DBRef
    private Player player;

    @NotNull
    private VillageCoordinates coordinates;
    
    private Collection<Build> builds;

}