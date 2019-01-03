package com.arturo.aerineapi.game.player.validators;

import com.arturo.aerineapi.game.player.Player;
import com.arturo.aerineapi.security.operation.OperationControl;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class BeforeSavePlayerValidator implements Validator {
    
    @Override
    public boolean supports(Class<?> clazz) {
        return Player.class.equals(clazz);
    }

    @Override
    @OperationControl
    public void validate(Object target, Errors errors) {
        Player player = (Player) target;
        
    }
}