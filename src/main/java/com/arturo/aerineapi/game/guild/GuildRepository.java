package com.arturo.aerineapi.game.guild;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface GuildRepository extends MongoRepository<Guild, String> {
    
}