package com.arturo.aerineapi.game.player.validators;

import com.arturo.aerineapi.game.player.Player;
import com.arturo.aerineapi.game.player.PlayerRepository;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class BeforeCreatePlayerValidator implements Validator {

    private static final Logger logger = LoggerFactory.getLogger(BeforeCreatePlayerValidator.class);

    @Autowired
    private PlayerRepository playerRepository;
    
    @Override
    public boolean supports(Class<?> clazz) {
        return Player.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        logger.info("Validating {}", target);
    }
}