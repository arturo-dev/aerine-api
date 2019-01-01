package com.arturo.aerineapi.game.player;

import javax.validation.Valid;

import com.arturo.aerineapi.user.User;
import com.arturo.aerineapi.user.UserRepository;
import com.arturo.aerineapi.security.SecurityService;
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
    private UserRepository userRepository;

    @Autowired
    private SecurityService securityService;

    @HandleBeforeCreate
    public void handleBeforeCreate(@Valid Player player) {
        player.setResources(new PlayerResources());
        logger.info("Creating {}", player);
    }

    @HandleAfterCreate
    @OperationSecure
    public void handleAfterCreate(Player player) {
        String username = securityService.getAuth().getName();

        logger.info("Updating user {} to set player {}", username, player.getId());
        User user = userRepository.save(
            User
                .builder()
                .username(username)
                .player(player)
                .build());
        logger.info("Updated user {}", user);
    }

    @HandleBeforeSave
    public void handleBeforeSave(Player player) {
        logger.info("Updating {}", player);
    }

    @HandleBeforeDelete
    public void handleBeforeDelete(Player player) {
        logger.info("Deleting {}", player);
    }
    
}