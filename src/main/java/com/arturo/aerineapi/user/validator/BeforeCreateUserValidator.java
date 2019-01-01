package com.arturo.aerineapi.user.validator;

import com.arturo.aerineapi.user.User;
import com.arturo.aerineapi.user.UserRepository;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class BeforeCreateUserValidator implements Validator {

    private static final Logger logger = LoggerFactory.getLogger(BeforeCreateUserValidator.class);

    @Autowired
    private UserRepository userRepository;
    
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        logger.info("Validating {}", target);

        User user = (User) target;
        User inDB = userRepository.findOneByUsername(user.getUsername());

        if (inDB != null) {
            errors.rejectValue("username", "", "User.Email.Exists");
        }

        if (StringUtils.isBlank(user.getPassword())) {
            errors.rejectValue("password", "", "User.Password.Required");
        }

    }
}