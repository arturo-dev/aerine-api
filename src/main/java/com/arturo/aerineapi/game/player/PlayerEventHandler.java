package com.arturo.aerineapi.game.player;

import java.util.UUID;

import javax.validation.Valid;

import com.arturo.aerineapi.security.SecurityService;
import com.arturo.aerineapi.security.operation.OperationControl;
import com.arturo.aerineapi.security.operation.OperationSecure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeDelete;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler(Player.class)
public class PlayerEventHandler {

    private static final Logger logger = LoggerFactory.getLogger(PlayerEventHandler.class);

    @Autowired
    private SecurityService securityService;

    @HandleBeforeCreate
    public void handleBeforeCreate(@Valid Player player) {
        String name = String.format("[%s] %s", player.getServer().getName(), UUID.randomUUID().toString());

        player.setName(name);
        player.setLevel(0);
        player.setUser(securityService.getUser());

        logger.info("Creating {}", player);
    }

    @HandleAfterCreate
    @OperationSecure
    public void handleAfterCreate(Player player) {
        logger.info("Created {}", player);
    }

    @HandleBeforeSave
    @OperationControl
    public void handleBeforeSave(Player player) {
        logger.info("Updating {}", player);
    }

    @HandleBeforeDelete
    public void handleBeforeDelete(Player player) {
        logger.info("Deleting {}", player);
    }
    
}