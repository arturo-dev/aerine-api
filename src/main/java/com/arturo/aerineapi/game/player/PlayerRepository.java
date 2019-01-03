package com.arturo.aerineapi.game.player;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.bson.types.ObjectId;

import com.arturo.aerineapi.game.server.Server;
import com.arturo.aerineapi.user.User;

@RestResource
public interface PlayerRepository extends MongoRepository<Player, ObjectId> {

    Player findOneByUserAndServer(@Param("user") User user, @Param("server") Server server);

}