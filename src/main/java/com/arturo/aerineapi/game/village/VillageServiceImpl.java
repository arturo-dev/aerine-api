package com.arturo.aerineapi.game.village;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.arturo.aerineapi.game.player.Player;
import com.arturo.aerineapi.security.operation.OperationControl;

@Service
public class VillageServiceImpl implements VillageService {

	private final static Logger logger = LoggerFactory.getLogger(VillageServiceImpl.class);
	
	@Override
	@OperationControl
	public Boolean canCreateOne(Player player) {
		logger.info("Checking if player {} can create village", player.getId());

		if (player.getLevel() == 0 
				&& (player.getVillages() == null || player.getVillages().size() == 0)) {
			return Boolean.TRUE;
		}
		
		return Boolean.TRUE;
	}
	
	@Override
	public VillageResouces initialResources() {
		return VillageResouces
				.builder()
				.gold(new Resource(0l, new Date()))
				.iron(new Resource(0l, new Date()))
				.food(new Resource(0l, new Date()))
				.build();
	}
	
}
