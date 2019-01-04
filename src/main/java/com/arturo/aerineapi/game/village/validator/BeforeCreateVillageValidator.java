package com.arturo.aerineapi.game.village.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.arturo.aerineapi.common.constant.Key;
import com.arturo.aerineapi.game.village.Village;
import com.arturo.aerineapi.game.village.VillageService;

@Component
public class BeforeCreateVillageValidator implements Validator {

    private static final Logger logger = LoggerFactory.getLogger(BeforeCreateVillageValidator.class);
    
    @Autowired
    private VillageService villageService;
    
    @Override
    public boolean supports(Class<?> clazz) {
        return Village.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        logger.info("Validating {}", target);
        Village village = (Village) target;
        
        
        if (village.getPlayer() == null || village.getPlayer().getId() == null) {
        	errors.rejectValue("player", "", Key.Validation.PLAYER_REQUIRED);
        }
        
        if (!villageService.canCreateOne(village.getPlayer())) {
        	errors.rejectValue("player.level", "", Key.Validation.PLAYER_INVALID_LEVEL);
        }
    }
}