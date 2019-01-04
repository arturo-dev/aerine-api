package com.arturo.aerineapi.game.village;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.arturo.aerineapi.game.player.Player;

public interface VillageRepository extends MongoRepository<Village, String> {
	
	Long countByPlayer(Player player);
	
}