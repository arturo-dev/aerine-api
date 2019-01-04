package com.arturo.aerineapi.game.village;

import java.util.Arrays;
import java.util.UUID;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeDelete;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import com.arturo.aerineapi.game.build.BuildService;
import com.arturo.aerineapi.game.player.PlayerRepository;
import com.arturo.aerineapi.security.operation.OperationControl;
import com.arturo.aerineapi.security.operation.OperationSecure;

@Component
@RepositoryEventHandler(Village.class)
public class VillageEventHandler {

    private static final Logger logger = LoggerFactory.getLogger(VillageEventHandler.class);
    
    @Autowired
    private PlayerRepository playerRepository;
    
    @Autowired
    private VillageService villageService;

    @Autowired
    private BuildService buildService;

    @HandleBeforeCreate
    public void handleBeforeCreates(@Valid Village village) {
    	String name = String.format("[%s] %s", village.getPlayer().getName(), UUID.randomUUID().toString());
    	
    	village.setName(name);
    	village.setResources(villageService.initialResources());
        village.setBuilds(buildService.defaultBuilds());
        
        logger.info("Creating {}", village);
    }
    
    @HandleAfterCreate
    @OperationSecure
    public void handleAfterCreate(Village village) {
        logger.info("Created {}", village);
        
        if (village.getPlayer().getVillages() == null) {
        	village.getPlayer().setVillages(Arrays.asList(village));
        } else {
        	village.getPlayer().getVillages().add(village);
        }
        
        playerRepository.save(village.getPlayer());
        logger.info("Updated Player {} with Village {}", village.getPlayer().getId(), village.getId());
    }

    @HandleBeforeSave
    @OperationControl
    public void handleBeforeSave(Village village) {
        logger.info("Updating {}", village);
    }

    @HandleBeforeDelete
    public void handleBeforeDelete(Village village) {
        logger.info("Deleting {}", village);
    }
    
}