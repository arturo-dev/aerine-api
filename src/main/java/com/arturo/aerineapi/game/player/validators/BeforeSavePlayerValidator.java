package com.arturo.aerineapi.game.player.validators;

import com.arturo.aerineapi.game.player.Player;
import com.arturo.aerineapi.game.player.PlayerRepository;
import com.arturo.aerineapi.security.operation.OperationControl;
import com.arturo.aerineapi.user.User;
import com.arturo.aerineapi.user.UserRepository;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class BeforeSavePlayerValidator implements Validator {

    @Autowired
    private UserRepository userRepository;
    
    @Override
    public boolean supports(Class<?> clazz) {
        return Player.class.equals(clazz);
    }

    @Override
    @OperationControl
    public void validate(Object target, Errors errors) {
        Player player = (Player) target;
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findOneByPlayerId(player.getId());

        if (!StringUtils.equals(user.getUsername(), name)) {
            errors.rejectValue("user", "", "Player.Invalid.User");
        }
        
    }
}