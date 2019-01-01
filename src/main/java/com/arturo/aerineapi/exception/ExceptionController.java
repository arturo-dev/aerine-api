package com.arturo.aerineapi.exception;

import com.arturo.aerineapi.exception.error.ErrorMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.RepositoryConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @Autowired
    private ErrorMapper errorMapper;

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionDTO> handleRuntime(RuntimeException ex) {
        ex.printStackTrace();
        return new ResponseEntity<>(
            ExceptionDTO
                .builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .exception(ex.getClass().getSimpleName())
                .build(),
            HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ExceptionRest.class)
    public ResponseEntity<ExceptionDTO> handleCustom(ExceptionRest ex) {
        ex.printStackTrace();
        return new ResponseEntity<>(
            ExceptionDTO
                .builder()
                .status(ex.getStatus())
                .message(ex.getMessage())
                .build(),
            ex.getStatus());
    }

    @ExceptionHandler({ RepositoryConstraintViolationException.class })
    public ResponseEntity<ExceptionDTO> handleConstraintViolation(RepositoryConstraintViolationException ex) {
        ex.printStackTrace();
        return new ResponseEntity<>(
            ExceptionDTO
                .builder()
                .status(HttpStatus.BAD_REQUEST)
                .errors(errorMapper.mapObjectError(ex.getErrors().getAllErrors()))
                .build(), 
            HttpStatus.BAD_REQUEST);
    }


}