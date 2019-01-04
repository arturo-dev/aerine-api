package com.arturo.aerineapi.game.village;

import com.arturo.aerineapi.game.player.Player;

public interface VillageService {

	Boolean canCreateOne(Player player);
	
	VillageResouces initialResources();
	
}
