package com.arturo.aerineapi.user;

import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

import javax.validation.Valid;

import com.arturo.aerineapi.game.player.Player;
import com.arturo.aerineapi.game.player.PlayerRepository;
import com.arturo.aerineapi.security.operation.Operation;
import com.arturo.aerineapi.security.operation.OperationControl;
import com.arturo.aerineapi.security.operation.OperationRepository;
import com.arturo.aerineapi.security.operation.OperationSecure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeDelete;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler(User.class)
public class UserEventHandler {

    private static final Logger logger = LoggerFactory.getLogger(UserEventHandler.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private OperationRepository operationRepository;

    @HandleBeforeCreate
    public void handleBeforeCreate(User user) {
        Authority auth = new Authority("ROLE_USER");

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(Boolean.TRUE);
        user.setAccountNonExpired(Boolean.TRUE);
        user.setAccountNonLocked(Boolean.TRUE);
        user.setCredentialsNonExpired(Boolean.TRUE);
        user.setAuthorities(Arrays.asList(auth));
        user.setCreation(new Date());

        logger.info("Creating {}", user);
    }

    @HandleAfterCreate
    public void handleAfterCreate(User user) {
        logger.info("Created {}", user);
        logger.info("Adding operation {} on {}", user.getId(), user);
        operationRepository.save(
            Operation.builder()
            .id(user.getId())
            .alloweds(Arrays.asList(user.getId()))
            .build());
    }

    @HandleBeforeSave
    @OperationControl
    public void handleBeforeSave(User user) {
        logger.info("Updating {}", user);
    }

    @HandleBeforeDelete
    public void handleBeforeDelete(User user) {
        logger.info("Deleting {}", user);
    }
    
}