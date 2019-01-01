package com.arturo.aerineapi.user.validator;

import com.arturo.aerineapi.user.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class BeforeDeleteUserValidator implements Validator {

    private static final Logger logger = LoggerFactory.getLogger(BeforeDeleteUserValidator.class);
    
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        logger.info("Validating {}", target);
    }
}