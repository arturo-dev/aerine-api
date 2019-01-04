package com.arturo.aerineapi.exception;

import java.util.Collection;

import org.springframework.http.HttpStatus;

import com.arturo.aerineapi.exception.error.ErrorApi;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Data
@Builder
@JsonInclude(Include.NON_NULL)
@Generated
public class ExceptionDTO {

    private HttpStatus status;
    private String message;
    private String exception;
    private Collection<ErrorApi> errors;

}