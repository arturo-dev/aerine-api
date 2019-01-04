package com.arturo.aerineapi.game.village;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import com.arturo.aerineapi.game.build.Build;
import com.arturo.aerineapi.game.player.Player;
import com.sun.istack.NotNull;

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
public class Village {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private ObjectId id;

    private String name;
    
    private VillageResouces resources;
    
    @DBRef(lazy = true)
    private Player player;

    @NotNull
    private VillageCoordinates coordinates;
    
    private List<Build> builds;

}