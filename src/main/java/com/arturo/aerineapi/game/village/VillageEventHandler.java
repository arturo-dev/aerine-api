package com.arturo.aerineapi.game.village;

import javax.validation.Valid;

import com.arturo.aerineapi.game.build.BuildService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeDelete;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler(Village.class)
public class VillageEventHandler {

    private static final Logger logger = LoggerFactory.getLogger(VillageEventHandler.class);

    @Autowired
    private VillageRepository villageRepository;

    @Autowired
    private BuildService buildService;

    @HandleBeforeCreate
    public void handleBeforeCreates(@Valid Village village) {
        village.setBuilds(buildService.defaultBuilds());
        logger.info("Creating {}", village);
    }

    @HandleBeforeSave
    public void handleBeforeSave(Village village) {
        logger.info("Updating {}", village);
    }

    @HandleBeforeDelete
    public void handleBeforeDelete(Village village) {
        logger.info("Deleting {}", village);
    }
    
}