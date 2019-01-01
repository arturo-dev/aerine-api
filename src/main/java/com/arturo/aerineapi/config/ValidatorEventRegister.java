package com.arturo.aerineapi.config;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;

@Configuration
public class ValidatorEventRegister implements InitializingBean {

    @Autowired
    private ValidatorEventListener validatorEventListener;
 
    @Autowired
    private Map<String, Validator> validators;
 
    @Override
    public void afterPropertiesSet() throws Exception {
        List<String> events = Arrays.asList(
            "beforeCreate", 
            "afterCreate",
            "beforeSave", 
            "beforeDelete");

        for (Map.Entry<String, Validator> entry : validators.entrySet()) {
            events.stream()
              .filter(p -> entry.getKey().startsWith(p))
              .findFirst()
              .ifPresent(
                p -> validatorEventListener
               .addValidator(p, entry.getValue()));
        }
    }
}