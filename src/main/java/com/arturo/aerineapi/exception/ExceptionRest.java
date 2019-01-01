package com.arturo.aerineapi.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;

@Data
@AllArgsConstructor
@Generated
public class ExceptionRest extends RuntimeException {

    private HttpStatus status;
    private String message;

}