package com.arturo.aerineapi.exception.error;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Component;
import org.springframework.validation.ObjectError;

@Component
public class ErrorMapper {


    public Collection<ErrorApi> mapObjectError(Collection<ObjectError> errors) {
        Collection<ErrorApi> map = new ArrayList<ErrorApi>();
        errors.forEach(e -> {
            map.add(ErrorApi
                .builder()
                .code(e.getCode())
                .defaultMessage(e.getDefaultMessage())
                .objectName(e.getObjectName())
                .build());
        });

        return map;
    }

}